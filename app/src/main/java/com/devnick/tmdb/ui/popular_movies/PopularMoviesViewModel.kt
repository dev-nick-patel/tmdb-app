package com.devnick.tmdb.ui.popular_movies

import androidx.lifecycle.*
import com.devnick.tmdb.data.popular_movie.PopularMoviesResults
import com.devnick.tmdb.repository.TmdbRepository
import com.devnick.tmdb.util.Resource
import com.devnick.tmdb.util.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull


class PopularMoviesViewModel : ViewModel() {

    private var _text = MutableLiveData<String>()
    var text: LiveData<String> = _text

    private var _isEmpty = MutableLiveData<Boolean>()
    var isEmpty: LiveData<Boolean> = _isEmpty

    var _isConnected = MutableLiveData<Boolean>()
    val isConnected: LiveData<Boolean> = _isConnected

    var _loading = MutableLiveData<Status>()
    val loading: LiveData<Status> = _loading

    var _movieList = MutableLiveData<PopularMoviesResults>()
    val movieList: LiveData<PopularMoviesResults> = _movieList

    private val tmdbRepository: TmdbRepository = TmdbRepository()

    val popularMoviesList = liveData(Dispatchers.IO) {
        val popularMoviesResults = tmdbRepository.getPopularMoviesList()
        emit(popularMoviesResults)
    }


}