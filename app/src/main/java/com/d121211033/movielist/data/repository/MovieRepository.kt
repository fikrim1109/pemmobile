package com.d121211033.movielist.data.repository

import android.graphics.Movie
import com.d121211033.movielist.data.response.GetMovieDetailResponse
import com.d121211033.movielist.data.response.GetMovieImagesResponse
import com.d121211033.movielist.data.response.GetMovieResponse
import com.d121211033.movielist.data.source.remote.ApiService

class MovieRepository(private val apiService: ApiService) {
    suspend fun getBoxOfficeMovies(): List<Movie> {
        return apiService.getBoxOfficeMovies().results
    }

    suspend fun getMovieDetails(movieId: String): GetMovieDetailResponse {
        return apiService.getMovieDetails(movieId)
    }

    suspend fun getMovieImages(movieId: String): GetMovieImagesResponse {
        return apiService.getMovieImages(movieId)
    }
}
