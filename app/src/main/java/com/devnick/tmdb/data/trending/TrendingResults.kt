package com.devnick.tmdb.data.trending

data class TrendingResults(
    val page: Int,
    val results: List<Trending>,
    val total_pages: Int,
    val total_results: Int
)