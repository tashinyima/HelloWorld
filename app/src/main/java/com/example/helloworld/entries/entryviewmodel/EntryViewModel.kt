package com.example.helloworld.entries.entryviewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.helloworld.entries.data.database.EntryEntity
import com.example.helloworld.entries.repository.entryRepository.EntriesRepository
import com.example.helloworld.entries.model.entries.Entries
import com.example.helloworld.entries.model.entries.Entry
import com.example.helloworld.entries.repository.localdbrepository.LocaldbRepository
import com.example.helloworld.entries.repository.mainrepository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

// inject constructor tells hilt ... ???? :( --- ???
// entry repository  is provided by DI via reposo module

@HiltViewModel
//class EntryViewModel @Inject constructor(private val entriesRepository: EntriesRepository) : ViewModel() {
class EntryViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {


    // Room Database
// Dispatcher IO runs on different thread
    lateinit var readEntry :LiveData<List<EntryEntity>>

       fun load(){
           readEntry= liveData {
               emitSource(mainRepository.local.getLocalData().asLiveData())

//      kunsang references .. emitSource(announcementRepository.getAllAnnouncement().asLiveData())
           }
       }



    private fun insertEntries(entryEntity: EntryEntity) = viewModelScope.launch(Dispatchers.IO) {
        mainRepository.local.insertData(entryEntity)
    }

    // entry liveData
    //Retrofit
    var entriesLiveData = MutableLiveData<Entries>()
    fun retrieveEntries() {
        // coroutineScope due to suspend keywords which should have to run on a diff thread
        viewModelScope.launch {
            entriesLiveData.postValue(mainRepository.remote.getEntries())
            val entries = mainRepository.remote.getEntries()
            Log.i("EntryViewModel", entries.toString())


            if (entries!= null) {
                offlineCacheEntry(entries)
            }




        }


    }

    private fun offlineCacheEntry(entries: Entries) {
        val entryEntity = EntryEntity(entries)
        insertEntries(entryEntity)


    }

}