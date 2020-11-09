package com.devnick.tmdb.repository

import com.devnick.tmdb.MyApplication.Companion.API_KEY
import com.devnick.tmdb.network.ApiService
import com.devnick.tmdb.network.RetrofitBuilder

class TmdbRepository {

    private val apiService = RetrofitBuilder.buildService(ApiService::class.java)

    suspend fun getPopularMoviesList() = apiService.getPopularMoviesList(API_KEY)
    suspend fun getTrendingMoviesList() = apiService.getTrendingList(API_KEY)
}