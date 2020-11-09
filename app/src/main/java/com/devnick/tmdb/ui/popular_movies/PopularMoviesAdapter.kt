package com.devnick.tmdb.ui.popular_movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devnick.tmdb.data.popular_movie.PopularMovies
import com.devnick.tmdb.databinding.RawPopularMovieListBinding

class PopularMoviesAdapter(val moviesList: List<PopularMovies>): RecyclerView.Adapter<PopularMoviesAdapter.MoviesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = RawPopularMovieListBinding.inflate(view)
        return MoviesViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        return holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
inner class MoviesViewHolder(val binding: RawPopularMovieListBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: PopularMovies) {
        binding.popularMovie = movie
    }
}
}
