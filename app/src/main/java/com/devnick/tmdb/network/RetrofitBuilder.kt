package com.devnick.tmdb.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitBuilder {

    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


//    @Singleton
//    @Provides
//    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
//        .baseUrl("https://api.themoviedb.org/")
//        .addConverterFactory(GsonConverterFactory.create(gson))
//        .build()
//
//    // for moshi
//
//    @Singleton
//    @Provides
//    fun provideRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder()
//        .baseUrl("https://api.themoviedb.org/")
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .build()
//
//
//    @Provides
//    fun provideGson(): Gson = GsonBuilder().create()
//
//    @Provides
//    fun provideMoshi(): Moshi = Moshi.Builder().build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
    val apiService: ApiService = buildService(ApiService::class.java)

}