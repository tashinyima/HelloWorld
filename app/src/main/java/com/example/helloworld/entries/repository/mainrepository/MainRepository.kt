package com.example.helloworld.entries.repository.mainrepository

import com.example.helloworld.entries.repository.entryRepository.EntriesRepository
import com.example.helloworld.entries.repository.localdbrepository.LocaldbRepository
import javax.inject.Inject

// add remote and local data here which is passed to view model main
class MainRepository @Inject constructor(
    entriesRepository: EntriesRepository,
     localdbRepository: LocaldbRepository
) {
    val remote = entriesRepository
    val local = localdbRepository
}