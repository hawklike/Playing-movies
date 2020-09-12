package cz.prague.steuejan.playingmovies.model.data.entities

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val title: String,
    @SerializedName("vote_average")
    val votes: Double,
    @SerializedName("poster_path")
    val posterPath: String
)