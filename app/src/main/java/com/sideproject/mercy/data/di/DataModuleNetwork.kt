package com.sideproject.mercy.data.di

import android.app.Application
import androidx.room.Room
import com.sideproject.mercy.data.Config.BASE_URL
import com.sideproject.mercy.data.local.MercyDatabase
import com.sideproject.mercy.data.remote.api.MercyAPI
import com.sideproject.mercy.data.repository.OnBoardingGatewayImpl
import com.sideproject.mercy.domain.gateway.OnBoardingGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModuleNetwork {
    private const val TIME_OUT = 15L

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()


    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideCurrencyService(retrofit: Retrofit): MercyAPI =
        retrofit.create(MercyAPI::class.java)

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): MercyDatabase {
        return Room.databaseBuilder(
            app,
            MercyDatabase::class.java,
            "mercy_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: MercyDatabase, api: MercyAPI): OnBoardingGateway {
        return OnBoardingGatewayImpl(api, db.mercyDao)
    }
}