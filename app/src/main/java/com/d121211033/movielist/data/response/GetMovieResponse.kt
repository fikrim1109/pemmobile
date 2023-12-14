package com.d121211033.movielist.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResult(
    @SerialName("title")
    val title: String,
    @SerialName("year")
    val year: String,
    @SerialName("imdbId")
    val imdbId: String
)

@Serializable
data class GetMovieResponse(
    @SerialName("movie_results")
    val movieResults: List<MovieResult>,
    @SerialName("results")
    val results: Int,
    @SerialName("Total_results")
    val totalResults: String,
    @SerialName("status")
    val status: String,
    @SerialName("status_message")
    val statusMessage: String
)

fun main() {
    // Gantilah jsonString dengan respon JSON yang Anda terima dari API
    val jsonString = """
        {
    "movie_results": [
        {
            "title": "Waitress: The Musical",
            "year": "2023",
            "imdb_id": "tt15477042"
        },
        {
            "title": "Renaissance: A Film by Beyoncé",
            "year": "2023",
            "imdb_id": "tt29354040"
        },
        {
            "title": "Animal",
            "year": "2023",
            "imdb_id": "tt13751694"
        },
        {
            "title": "The Shift",
            "year": "2023",
            "imdb_id": "tt19406606"
        },
        {
            "title": "Wish",
            "year": "2023",
            "imdb_id": "tt11304740"
        },
        {
            "title": "Napoleon",
            "year": "2023",
            "imdb_id": "tt13287846"
        },
        {
            "title": "The Hunger Games: The Ballad of Songbirds & Snakes",
            "year": "2023",
            "imdb_id": "tt10545296"
        },
        {
            "title": "Godzilla Minus One",
            "year": "2023",
            "imdb_id": "tt23289160"
        },
        {
            "title": "Trolls Band Together",
            "year": "2023",
            "imdb_id": "tt14362112"
        },
        {
            "title": "The Boy and the Heron",
            "year": "2023",
            "imdb_id": "tt6587046"
        }
    ],
    "results": 10,
    "Total_results": "10",
    "status": "OK",
    "status_message": "Query was successful"
}
    """

    // Konversi JSON menjadi objek Kotlin menggunakan Kotlinx Serialization
    val moviesResponse = kotlinx.serialization.json.Json.decodeFromString(GetMovieResponse.serializer(), jsonString)

    // Ambil ID IMDb dari setiap film
    val imdbIds = moviesResponse.movieResults.map { it.imdbId }

    // Cetak ID IMDb
    println("IMDb IDs:")
    imdbIds.forEach { println(it) }
}
