package com.example.helloworld.entries.entryviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloworld.entries.entryRepository.EntriesRepository
import com.example.helloworld.entries.model.Entries
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
// inject constructor tells hilt ... ???? :( --- ???
// entry repository  is provided by DI via reposo module

@HiltViewModel
class EntryViewModel @Inject constructor(private val entriesRepository: EntriesRepository) : ViewModel() {

    // entry liveData
    var entriesLiveData = MutableLiveData<Entries>()
     fun retrieveEntries() {
        // coroutineScope due to suspend keywords which should have to run on a diff thread
        viewModelScope.launch {
            entriesLiveData.postValue(entriesRepository.getEntries())

        }


    }

}