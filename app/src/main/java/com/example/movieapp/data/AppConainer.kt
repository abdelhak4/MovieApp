package com.example.movieapp.data

import com.example.movieapp.remote.MovieApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


interface AppConainer {
    val movieRepository: MovieRepository
}

class DefaultAppContainer() : AppConainer {

    private val BASE_URL = "https://api.themoviedb.org/3/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNDM2ZTg5ZDA2OGMxNTQxYmZjODJiNDE2M2I3OGUwYiIsInN1YiI6IjY1NjQ2ZDk0MzY3OWExMDk3NjQ4NWViOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.-XAtKwaVC8Nt5Zcz8MbR88t1oJYYqnQLAnRxc4Au4Jg")
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