package com.d121211033.movielist.data.repository

import com.d121211033.movielist.data.models.Movie as MovieModel
import com.d121211033.movielist.data.response.GetMovieDetailResponse
import com.d121211033.movielist.data.response.GetMovieImageResponse
import com.d121211033.movielist.data.source.remote.ApiService
import com.d121211033.movielist.data.response.GetMovieResponse as MovieResponse

class MovieRepository(private val apiService: ApiService) {
    suspend fun getMovie(): Int {
        return apiService.getMovie().results
    }

    suspend fun getMovieDetails(imdbId: String): GetMovieDetailResponse {
        // Pastikan Anda memberikan parameter yang benar ke fungsi ApiService
        return apiService.getMovieDetails(imdbId)
    }

    suspend fun getMovieImage(imdbId: String): GetMovieImageResponse {
        // Pastikan Anda memberikan parameter yang benar ke fungsi ApiService
        return apiService.getMovieImages(imdbId)
    }
}
