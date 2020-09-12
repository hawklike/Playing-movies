package cz.prague.steuejan.playingmovies.model.api

import cz.prague.steuejan.playingmovies.model.data.entities.Movie
import cz.prague.steuejan.playingmovies.model.response.MovieTmdbResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface TmdbApi {
    @GET("movie/now_playing")
    fun getPlayingMoviesAsync(): Deferred<Response<MovieTmdbResponse>>
}
