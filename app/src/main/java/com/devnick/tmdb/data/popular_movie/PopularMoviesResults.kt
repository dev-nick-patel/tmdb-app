package com.devnick.tmdb.data.popular_movie

data class PopularMoviesResults(
    val page: Int,
    val results: List<PopularMovies>,
    val total_pages: Int,
    val total_results: Int
)