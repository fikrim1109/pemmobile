package com.d121211033.movielist.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class GetMovieImageResponse(
    @SerialName("posterUrl")
    val poster_path: String,
    @SerialName("backdropUrl")
    val backdropUrl: String,

)
