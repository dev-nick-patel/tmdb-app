package com.devnick.tmdb.ui.trending

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.devnick.tmdb.R
import com.devnick.tmdb.databinding.TrendingFragmentBinding
import com.devnick.tmdb.util.InternetUtil

class TrendingFragment : Fragment() {

    companion object {
        fun newInstance() = TrendingFragment()
    }

    private val trendingViewModel by viewModels<TrendingViewModel>()
    private lateinit var binding: TrendingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TrendingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this.viewLifecycleOwner
        InternetUtil.observe(viewLifecycleOwner, Observer { isAvailable ->
            when (isAvailable) {
                true -> {
                    binding.noInternetText.visibility = View.GONE
                    trendingViewModel.getTrendingList.observe(viewLifecycleOwner, Observer {
                        binding.progressBar.visibility = View.GONE
                        binding.trendingAdapter = TrendingAdapter(it.results)
                    })
                }
                false -> {
                    binding.noInternetText.visibility = View.VISIBLE
                    binding.noInternetText.text = getString(R.string.no_internet)
                }
            }
        })


    }

}