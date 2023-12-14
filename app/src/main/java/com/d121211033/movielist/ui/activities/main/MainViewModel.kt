package com.d121211033.movielist.ui.activities.main

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.d121211033.movielist.data.models.Movie
import com.d121211033.movielist.data.repository.MovieRepository
import com.d121211033.movielist.data.response.GetMovieDetailResponse
import com.d121211033.movielist.data.response.GetMovieImageResponse


class MainViewModel {
    val mainUiState: MainActivity.MainUiState
        get() {
            TODO()
        }

    class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
        private val _selectedMovieId = MutableLiveData<String>()

        // Function to set the selected movieId
        fun setSelectedMovieId(movieId: String) {
            _selectedMovieId.value = movieId
        }

        // Function to get movie details
        suspend fun getMovieDetails(): GetMovieDetailResponse {
            val movieId = _selectedMovieId.value ?: throw IllegalStateException("MovieId not set")
            return repository.getMovieDetails(movieId)
        }

        // Function to get movie images
        suspend fun getMovieImages(): GetMovieImageResponse {
            val movieId = _selectedMovieId.value ?: throw IllegalStateException("MovieId not set")
            return repository.getMovieImage(movieId)
        }
    }

    class Factory {
        val viewModel: MovieViewModel
            get() {
                TODO()
            }

    }

}