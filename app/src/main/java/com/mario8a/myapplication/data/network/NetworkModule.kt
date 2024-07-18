package com.mario8a.myapplication.data.network

import com.mario8a.myapplication.data.RepositoryImpl
import com.mario8a.myapplication.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Esto permite injectar el objeto retorfir donde queramos
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit):HoroscopeApiService {
        return retrofit.create(HoroscopeApiService::class.java)
    }

    // retorna la implementacion del repositorio
    // Entender que dagger lo hace por detras la logica para injectar las dependencias
    @Provides
    fun providesRepository(apiService: HoroscopeApiService): Repository {
        return RepositoryImpl(apiService)
    }
}