package com.d121211033.movielist.ui.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.android.volley.toolbox.ImageRequest
import com.d121211033.movielist.data.models.Movie
import com.d121211033.movielist.ui.theme.MovieListTheme

class DetailActivity : ComponentActivity {

    private var selectedMovie : Movie? = null

override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedMovie = intent.getParcelableExtra("MOVIE")
        setContent {
            MovieListTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen()
                }
            }
        }
    }

@Composable
    fun DetailScreen() {
        coloumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
               // Movie Poster (Portrait)
                AsyncImage(
                 model = ImageRequest.Builder(context = LocalContext.current)
                      .data("movies-tv-shows-database.p.rapidapi.com" + selectedMovie?.poster_path)
                      .crossfade(true)
                      .build(),
                 contentDescription = "Movie Poster",
                 contentScale = ContentScale.Crop,
                 modifier = Modifier
                      .fillMaxWidth()
                      .height(400.dp)
                      .clip(RoundedCornerShape(8.dp))
                )
    
                Spacer(modifier = Modifier.height(16.dp))
    
                // Movie Title
                Text(
                 text = selectedMovie?.title ?: "",
                 style = MaterialTheme.typography.h6,
                 fontWeight = FontWeight.Bold
                )
    
                Spacer(modifier = Modifier.height(8.dp))
    
                // Movie Release Date
                Text(
                 text = selectedMovie?.release_date ?: "",
                 style = MaterialTheme.typography.body1
                )
    
                Spacer(modifier = Modifier.height(8.dp))
    
                // Movie Overview
                Text(
                 text = selectedMovie?.overview ?: "",
                 style = MaterialTheme.typography.body1
                )
        }
    }


}