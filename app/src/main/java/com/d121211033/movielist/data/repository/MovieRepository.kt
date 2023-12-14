package com.d121211033.movielist.data.repository

import com.d121211033.movielist.data.models.Movie
import com.d121211033.movielist.data.response.GetMovieDetailResponse
import com.d121211033.movielist.data.response.GetMovieImageResponse
import com.d121211033.movielist.data.source.remote.ApiService

class MovieRepository(private val apiService: ApiService) {
    suspend fun getMovie(): List<Movie> {
        return apiService.getMovie().results
    }

    suspend fun getMovieDetails(movieId: String): GetMovieDetailResponse {
        return apiService.getMovieDetails(movieId)
    }

    suspend fun getMovieImages(movieId: String): GetMovieImageResponse {
        return apiService.getMovieImages(movieId)
    }
}
