import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.volley.toolbox.ImageRequest
import com.d121211033.movielist.data.models.Movie
import com.d121211033.movielist.ui.activities.detail.DetailActivity
import com.d121211033.movielist.ui.activities.main.MainViewModel
import com.d121211033.movielist.ui.theme.MovieListTheme

class MainActivity : ComponentActivity() {
    sealed class MainUiState {
        object Loading : MainUiState()
        data class Error(val message: String) : MainUiState()
        data class Success(val movies: List<Movie>) : MainUiState()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        CenterAlignedTopAppBar(
                            modifier = Modifier.background(Color.Blue),
                            title = {
                                Text(
                                    text = "MovieList",
                                    fontWeight = FontWeight.SemiBold,
                                )
                            }
                        )
                        val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory())
                        ListMoviesScreen(mainViewModel.mainUiState)
                    }
                }
            }
        }
    }

    private fun viewModel(factory: Any): MainViewModel {
        TODO()
    }

    @Composable
    private fun ListMoviesScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when (mainUiState) {
            is MainUiState.Loading -> Text(text = "Sedang Loading", fontSize = 16.sp)
            is MainUiState.Error -> Text(text = "Terjadi Error", fontSize = 16.sp)
            is MainUiState.Success -> MovieList(mainUiState.movies)
            else -> {   // Note the block
                Text(text = "Terjadi Error", fontSize = 16.sp)}
        }
    }

    @Composable
    fun MovieList(movies: List<Movie>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(movies) { movie ->
                MovieItem(movie = movie)
            }
        }
    }

    @Composable
    fun MovieItem(movie: Movie) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .clickable {
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra("MOVIE", movie)
                    startActivity(intent)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
// Movie Poster
                AsyncImage(
                    model = CoilImageRequest.Builder(LocalContext.current)
                        .data("https://movies-tv-shows-database.p.rapidapi.com" + movie.poster_path)
                        .crossfade(true)
                        .build(),
                    contentDescription = movie.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                // Movie Details
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = movie.title.toString(),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = movie.release_date.toString(),
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = movie.description.toString(), style = MaterialTheme.typography.bodyMedium)

                // Other details like rating, genre, etc. can be added here
            }
        }
    }

    private @Composable
    fun AsyncImage(
        model: Any,
        contentDescription: String,
        modifier: Modifier,
        contentScale: ContentScale
    ) {
        TODO("Not yet implemented")
    }
}

class CoilImageRequest {

    class Builder(current: Any) {
        fun data(s: String): Builder {
            TODO()
        }

        fun crossfade(b: Boolean): Builder {
            TODO()
        }

        fun build(): Any {
            TODO()
        }
    }
}

sealed class MainUiState {
    object Loading : MainUiState()
    data class Error(val message: String) : MainUiState()
    data class Success(val movies: List<Movie>) : MainUiState()
}

