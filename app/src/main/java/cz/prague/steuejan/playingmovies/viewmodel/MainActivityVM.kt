package cz.prague.steuejan.playingmovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.prague.steuejan.playingmovies.model.api.ApiFactory
import cz.prague.steuejan.playingmovies.model.data.entities.Movie
import cz.prague.steuejan.playingmovies.model.repository.MovieRepository
import cz.prague.steuejan.playingmovies.model.response.MovieTmdbResponse
import cz.prague.steuejan.playingmovies.model.response.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityVM : ViewModel() {
    private val repository = MovieRepository(ApiFactory.tmdbApi)

    private val _playingMovies = MutableLiveData<List<Movie>>()
    val playingMovies: LiveData<List<Movie>> = _playingMovies

    fun getPlayingMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            when(val result = repository.getPlayingMovies()) {
                is Result.Success -> _playingMovies.postValue((result.data as MovieTmdbResponse).results)
                is Result.Failure -> println(result.what)
            }
        }
    }
}
