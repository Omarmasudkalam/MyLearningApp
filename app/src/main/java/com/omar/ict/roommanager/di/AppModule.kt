package com.omar.ict.roommanager.di

import com.omar.ict.roommanager.data.EmployeeApi
import com.omar.ict.roommanager.data.NewsApi
import com.omar.ict.roommanager.data.NewsApiDetails
import com.omar.ict.roommanager.data.PeopleApiDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module // to define the definition of  depoendancy injection
@InstallIn(SingletonComponent::class) //to define the scope of dependancy injection
class AppModule {
    //define all the dependancies you will use
    @Provides
    //provide the retrofit instance
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(PeopleApiDetails.BASE_URL)
        .build()

    @Provides
    //to provide the API instance references in code use
    fun provideAPI(retrofit: Retrofit): EmployeeApi =retrofit.create(EmployeeApi::class.java)

    @Provides
    //to provide the API instance references in code use
    fun provideNewsAPI(retrofit: Retrofit): NewsApi =retrofit.newBuilder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(NewsApiDetails.BASE_URL)
        .build().create(NewsApi::class.java)
}

/*

    @Provides
    //to provide the API instance references in code use
    fun provideNewsAPI(retrofit: Retrofit): NewsApi {
    return retrofit.newBuilder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(NewsApiDetails.BASE_URL)
    .build().create(NewsApi::class.java)
}
 */