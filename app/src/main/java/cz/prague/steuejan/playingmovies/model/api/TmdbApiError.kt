package cz.prague.steuejan.playingmovies.model.api

import com.google.gson.annotations.SerializedName
import cz.prague.steuejan.playingmovies.model.response.Error

data class TmdbApiError(
    @SerializedName("status_message")
    val message: String,
    @SerializedName("status_code")
    val code: Int
) : Error()