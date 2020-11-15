package com.devnick.tmdb.network

import com.devnick.tmdb.BuildConfig
import com.devnick.tmdb.data.popular_movie.PopularMoviesResults
import com.devnick.tmdb.data.trending.TrendingResults
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//    @GET("/3/movie/popular")
//    fun getPopularMoviesList(@Query("api_key") key: String): Call<PopularMovieResults>

    @GET("/3/movie/popular")
    suspend fun getPopularMoviesList(@Query("api_key") key: String = BuildConfig.API_KEY): PopularMoviesResults

    @GET("/3/trending/all/day")
    suspend fun getTrendingList(@Query("api_key") key: String = BuildConfig.API_KEY): TrendingResults

}