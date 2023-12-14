package com.d121211033.movielist.data

import com.d121211033.movielist.data.repository.MovieRepository
import com.d121211033.movielist.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val moviesRepository: MovieRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://api.themoviedb.org/3/"
    private val AUTH_TOKEN = "6dd0cd8742mshc56d55ce1293aecp13a8b4jsnb4dcc9cb2355"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val moviesRepository: MovieRepository by lazy {
        MovieRepository(retrofitService)
    }
}
