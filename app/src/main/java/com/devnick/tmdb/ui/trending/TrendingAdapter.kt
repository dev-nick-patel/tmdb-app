package com.devnick.tmdb.ui.trending

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devnick.tmdb.data.trending.Trending
import com.devnick.tmdb.databinding.RawTrendingListBinding

class TrendingAdapter(val trendingList: List<Trending>):
    RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = RawTrendingListBinding.inflate(view)
        return TrendingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        return holder.bind(trendingList[position])
    }

    override fun getItemCount(): Int {
        return trendingList.size
    }

    inner class TrendingViewHolder(val binding: RawTrendingListBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(trending: Trending)
        {
            binding.trending = trending
        }
    }

}