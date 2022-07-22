package com.horshun.saveup.di

import androidx.room.Room
import com.horshun.core.data.source.local.database.db.ActivityDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<ActivityDatabase>().activityDao() }
    single {
        Room.databaseBuilder(androidContext(), ActivityDatabase::class.java, "saveup.db")
            .fallbackToDestructiveMigration().build()
    }
}
