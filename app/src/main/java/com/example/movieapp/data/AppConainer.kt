package com.example.movieapp.data

import com.example.movieapp.remote.MovieApiService
import com.squareup.moshi.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


interface AppConainer {
    val movieRepository: MovieRepository
}

class DefaultAppContainer():AppConainer {

    private val BASE_URL = "https://api.themoviedb.org/3/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer c436e89d068c1541bfc82b4163b78e0b")
                .build()
            chain.proceed(request)
        }
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