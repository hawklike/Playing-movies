package cz.prague.steuejan.playingmovies.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.prague.steuejan.playingmovies.model.api.ApiFactory
import cz.prague.steuejan.playingmovies.model.repository.MovieRepository
import cz.prague.steuejan.playingmovies.model.response.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityVM : ViewModel() {
    private val repository = MovieRepository(ApiFactory.tmdbApi)

    private val _playingMovies = MutableLiveData<Result<*>>()

    fun getPlayingMovies() {

        viewModelScope.launch(Dispatchers.IO) {
            val foo = repository.getPlayingMovies()
            when(foo) {
                is Result.Failure -> println(foo.what.toString())
                is Result.Success -> println(foo.data.toString())
            }
        }
    }
}
