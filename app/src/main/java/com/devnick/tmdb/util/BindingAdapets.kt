package com.devnick.tmdb.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>?) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

@BindingAdapter(value = ["setImageUrl"])
fun ImageView.bindImageUrl(url: String?) {
    if (url != null && url.isNotBlank()) {

        Picasso.get()
            .load("http://image.tmdb.org/t/p/w500$url")
            .into(this, object : Callback {
                override fun onSuccess() {
                    Log.d("Adapter", "success")
                }

                override fun onError(e: Exception?) {
                    Log.d("Adapter", "error")
                }
            })

        //Glide.with(this.context).load("http://image.tmdb.org/t/p/w500$url").into(this)
    }
}

@BindingAdapter(value = ["android:src"])
fun ImageView.bindingSrc(url: String?) {
    if (url != null && url.isNotBlank()) {

        Glide.with(this.context).load("http://image.tmdb.org/t/p/w500$url").into(this)
    }
}