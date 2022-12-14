package com.omar.ict.roommanager.data.model.news


import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("articles")
    val articlesModel: List<Article> = listOf(),
    @SerializedName("status")
    val statusModel: String = "",
    @SerializedName("totalResults")
    val totalResultsModel: Int = 0
)