package cz.prague.steuejan.playingmovies.model.response

import cz.prague.steuejan.playingmovies.model.data.entities.Movie

data class MovieTmdbResponse(val results: List<Movie>)