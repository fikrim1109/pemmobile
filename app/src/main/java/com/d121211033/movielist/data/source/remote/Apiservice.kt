package com.d121211033.movielist.data.source.remote

import com.d121211033.movielist.data.response.GetMovieDetailResponse
import com.d121211033.movielist.data.response.GetMovieImagesResponse
import com.d121211033.movielist.data.response.GetMovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    suspend fun getBoxOfficeMovies(
        @Header("Type") type: String = "get-boxoffice-movies",
        @Header("X-RapidAPI-Key") apiKey: String = "6dd0cd8742mshc56d55ce1293aecp13a8b4jsnb4dcc9cb2355",
        @Header("X-RapidAPI-Host") apiHost: String = "movies-tv-shows-database.p.rapidapi.com",
        @Query("page") page: Int = 1
    ): GetMovieResponse

    @GET("/")
    suspend fun getMovieDetails(
        @Header("Type") type: String = "get-movie-details",
        @Header("X-RapidAPI-Key") apiKey: String = "6dd0cd8742mshc56d55ce1293aecp13a8b4jsnb4dcc9cb2355",
        @Header("X-RapidAPI-Host") apiHost: String = "movies-tv-shows-database.p.rapidapi.com",
        @Query("movieid") movieId: String
    ): GetMovieDetailResponse

    @GET("/")
    suspend fun getMovieImages(
        @Header("Type") type: String = "get-movies-images-by-imdb",
        @Header("X-RapidAPI-Key") apiKey: String = "6dd0cd8742mshc56d55ce1293aecp13a8b4jsnb4dcc9cb2355",
        @Header("X-RapidAPI-Host") apiHost: String = "movies-tv-shows-database.p.rapidapi.com",
        @Query("movieid") movieId: String
    ): GetMovieImagesResponse
}


