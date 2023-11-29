package com.example.movieapp.data

import com.example.movieapp.BuildConfig
import com.example.movieapp.remote.MovieApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


interface AppConainer {
    val movieRepository: MovieRepository
}

class DefaultAppContainer : AppConainer {

    private val BASE_URL = "https://api.themoviedb.org/3/"

    private val interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    val apiKey = BuildConfig.API_KEY
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $apiKey")
                .build()
            chain.proceed(request)
        }
        .addInterceptor(interceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()

        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
    override val movieRepository: MovieRepository by lazy {
        NetworkMovieRepository(retrofitService)
    }

}