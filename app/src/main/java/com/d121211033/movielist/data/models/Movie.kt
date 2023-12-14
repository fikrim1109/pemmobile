package com.d121211033.movielist.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Movie(
    val poster_path: String,
    val id: String,
    val title: String,
    val releaseDate: String,
    val genres: List<String>,
    val description: String,
    val imdbrating: String,
    val popularity: String,
    val rated: String,
    val release_date: String,
    val year: String
) : Parcelable
