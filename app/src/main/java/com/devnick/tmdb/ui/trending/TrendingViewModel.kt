package com.devnick.tmdb.ui.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.devnick.tmdb.data.trending.Trending
import com.devnick.tmdb.repository.TmdbRepository
import kotlinx.coroutines.Dispatchers

class TrendingViewModel : ViewModel() {

    private val tmdbRepository = TmdbRepository()
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage = _errorMessage
    private val _trendingList = MutableLiveData<List<Trending>>()
    val trendingList: LiveData<List<Trending>> = _trendingList

    val getTrendingList = liveData(Dispatchers.IO) {
        val trendingList = tmdbRepository.getTrendingMoviesList()
        emit(trendingList)
    }
}