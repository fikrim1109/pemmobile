package com.d121211033.movielist.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class GetMovieResponse(
    @SerialName("results")
    val results: List<Movie>
)

data class Movie(
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("year")
    val year: String,
)
