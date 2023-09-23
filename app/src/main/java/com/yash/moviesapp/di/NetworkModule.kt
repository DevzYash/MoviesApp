package com.yash.moviesapp.di

import com.yash.moviesapp.Api.AuthInterceptor
import com.yash.moviesapp.Api.MoviesApi
import com.yash.moviesapp.Utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
    }

    @Singleton
    @Provides
    fun providesOkHttp(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideMovieApi(retrofitBuilder: Retrofit.Builder,okkHttpClient: OkHttpClient): MoviesApi {
        return retrofitBuilder.client(okkHttpClient).build().create(MoviesApi::class.java)
    }



}