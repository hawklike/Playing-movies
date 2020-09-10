package cz.prague.steuejan.playingmovies.model.response

sealed class Result<out T: Any> {
    data class Success<out T: Any>(val data: T) : Result<T>()
    data class Failure(val what: Error) : Result<Nothing>()
    object Loading : Result<Nothing>()
}