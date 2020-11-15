package com.devnick.tmdb.ui.popular_movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.devnick.tmdb.R
import com.devnick.tmdb.databinding.FragmentPopularMoviesBinding
import com.devnick.tmdb.util.InternetUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.io.IOException
import java.lang.Exception

@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {

    private val popularMoviesViewModel by viewModels<PopularMoviesViewModel>()
    private lateinit var viewDataBinding: FragmentPopularMoviesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        return viewDataBinding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // set the lifecycle owner to the lifecycle view
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setupSnackbar()

        try {
            InternetUtil.observe(viewLifecycleOwner, Observer { isAvailable ->
                when (isAvailable) {
                    true -> {
                       // popularMoviesViewModel._isConnected.value = true
                       // binding.noInternetText.visibility = View.GONE
                        popularMoviesViewModel.popularMoviesList.observe(
                            viewLifecycleOwner,
                            Observer {
                               // popularMoviesViewModel._isConnected.value = true
                                viewDataBinding.adapter = PopularMoviesAdapter(it.results)
                            })
                    }
                    false -> {
                        popularMoviesViewModel._isConnected.value = false
                        viewDataBinding.progressBar.visibility = View.VISIBLE
                        viewDataBinding.noInternetText.visibility = View.VISIBLE
                        viewDataBinding.noInternetText.text = getString(R.string.no_internet)
                    }
                }
            })
        } catch (exception: Exception) {
            Log.e("PopularFragment", exception.message.toString())
            viewDataBinding.progressBar.visibility = View.VISIBLE
            viewDataBinding.noInternetText.visibility = View.VISIBLE
            viewDataBinding.noInternetText.text = exception.message
        }

    }

    private fun setupSnackbar() {

    }
}