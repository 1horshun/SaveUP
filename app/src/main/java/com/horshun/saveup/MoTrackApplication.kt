package com.horshun.saveup

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.horshun.core.data.source.local.data_store.PREFERENCE_NAME
import com.horshun.saveup.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

val Context.AppDataStore by preferencesDataStore(PREFERENCE_NAME)

@Suppress("unused")
class MoTrackApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MoTrackApplication)
            modules(listOf(
                databaseModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            ))
        }
    }

}