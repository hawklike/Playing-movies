package cz.prague.steuejan.playingmovies.model.repository

import cz.prague.steuejan.playingmovies.model.api.TmdbApi
import cz.prague.steuejan.playingmovies.model.api.TmdbApiError
import cz.prague.steuejan.playingmovies.model.data.entities.Movie
import cz.prague.steuejan.playingmovies.model.response.Result

class MovieRepository(private val api: TmdbApi) : BaseRepository() {

    suspend fun getPlayingMovies(): Result<Any> {
        return saveApiCall<List<Movie>, TmdbApiError> {
            api.getPlayingMoviesAsync().await()
        }
    }
}