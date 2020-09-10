package cz.prague.steuejan.playingmovies.model.repository

import com.google.gson.Gson
import cz.prague.steuejan.playingmovies.model.response.Error
import cz.prague.steuejan.playingmovies.model.response.Result
import retrofit2.Response

@Suppress("REDUNDANT_INLINE_SUSPEND_FUNCTION_TYPE")
abstract class BaseRepository {
    suspend inline fun <T : Any, reified E : Error> saveApiCall(call: suspend () -> Response<T>): Result<T> {
        val response = call.invoke()
        return if(response.isSuccessful) Result.Success(response.body()!!)
        else {
            val error = Gson().fromJson(response.errorBody()?.charStream(), E::class.java)
            Result.Failure(error)
        }
    }
}