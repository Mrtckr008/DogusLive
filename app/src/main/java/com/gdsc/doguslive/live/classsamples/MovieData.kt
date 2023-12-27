package com.gdsc.doguslive.live.classsamples

data class MovieData(
    val id: String,
    val name: String,
    val publishedYear: Int,
    val subtitleTypeList: ArrayList<String>,
    val hasWatched: Boolean
)
