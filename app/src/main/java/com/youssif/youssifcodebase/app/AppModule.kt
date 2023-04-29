package com.youssif.youssifcodebase.app

import android.content.Context
import com.youssif.youssifcodebase.R
import com.youssif.youssifcodebase.repository.api.AppAPIs
import com.youssif.youssifcodebase.repository.db.ArticleDatabase
import com.youssif.youssifcodebase.utils.AppPreference
import com.youssif.youssifcodebase.utils.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created by Youssif Hamdy on 1/31/2023.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context): ArticleDatabase {
        return ArticleDatabase.invoke(context)
    }

    @Singleton
    @Provides
    fun provideHttpLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideNetworkConnectionInterceptor(@ApplicationContext context: Context): NetworkConnectionInterceptor {
        return NetworkConnectionInterceptor(context)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor,
        networkConnectionInterceptor: NetworkConnectionInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(networkConnectionInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext context: Context, client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(context.getString(R.string.BASE_URL))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAPI(retrofit: Retrofit): AppAPIs {
        return retrofit.create(AppAPIs::class.java)
    }


    @Singleton
    @Provides
    fun providePreferences(): AppPreference {
        return AppPreference()
    }

}