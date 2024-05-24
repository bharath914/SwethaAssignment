package com.example.swethaassignment.di


import com.example.swethaassignment.data.BASE_URL
import com.example.swethaassignment.data.CowsApi
import com.example.swethaassignment.data.PagingSourceData
import com.example.swethaassignment.data.repo.CowsRepoImpl
import com.example.swethaassignment.data.repo.CowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofitApi(): CowsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CowsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCowsRepository(cowsApi: CowsApi): CowsRepository {
        return CowsRepoImpl(cowsApi)
    }


    @Provides
    @Singleton
    fun providePagerSource(cowsRepository: CowsRepository): PagingSourceData {
        return PagingSourceData(cowsRepository)
    }
}