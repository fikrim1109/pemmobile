package com.d121211033.movielist.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class GetMovieDetailResponse(
    @SerialName("imdbId")
    val imdbId: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("releaseDate")
    val releaseDate: String,
    @SerialName("genres")
    val genres: List<String>,
    @SerialName("popularity")
    val popularity: String,
    @SerialName("imdb_rating")
    val imdbRating: String,
    @SerialName("rated")
    val rated: String,
)
