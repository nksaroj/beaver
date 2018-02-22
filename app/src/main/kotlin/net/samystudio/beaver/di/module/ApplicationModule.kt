package net.samystudio.beaver.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import net.samystudio.beaver.BeaverApplication
import net.samystudio.beaver.BuildConfig
import net.samystudio.beaver.di.qualifier.ApplicationContext
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
abstract class ApplicationModule
{
    @Binds
    @Singleton
    abstract fun bindApplication(application: BeaverApplication): Application

    @Module
    companion object
    {
        @Provides
        @Singleton
        @ApplicationContext
        @JvmStatic
        fun provideApplicationContext(application: BeaverApplication): Context = application

        @Provides
        @Singleton
        @JvmStatic
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor
        {
            val httpLoggingInterceptor = HttpLoggingInterceptor()

            httpLoggingInterceptor.level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE

            return httpLoggingInterceptor
        }
    }
}
