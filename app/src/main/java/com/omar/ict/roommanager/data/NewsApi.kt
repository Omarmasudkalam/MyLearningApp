package com.omar.ict.roommanager.data

import com.omar.ict.roommanager.data.model.news.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET(NewsApiDetails.Country) //to define type of request GET, POST, PUT
    suspend fun getNews(
        @Query ("country") country:String ="GB",
        @Query ("apiKey") apiKey:String =NewsApiDetails.API_KEY

    ): Response<News>
}