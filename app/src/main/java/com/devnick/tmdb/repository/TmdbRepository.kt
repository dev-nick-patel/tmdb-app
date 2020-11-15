package com.devnick.tmdb.repository


import com.devnick.tmdb.network.ApiService
import com.devnick.tmdb.network.RetrofitBuilder

class TmdbRepository {

    private val apiService = RetrofitBuilder.buildService(ApiService::class.java)

    suspend fun getPopularMoviesList() = apiService.getPopularMoviesList()
    suspend fun getTrendingMoviesList() = apiService.getTrendingList()
}