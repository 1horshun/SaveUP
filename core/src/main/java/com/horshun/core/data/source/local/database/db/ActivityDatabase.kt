package com.horshun.core.data.source.local.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.horshun.core.data.source.local.database.entity.ActivityEntity

@Database(entities = [ActivityEntity::class], version = 1, exportSchema = false)
abstract class ActivityDatabase: RoomDatabase() {
    abstract fun activityDao(): ActivityDao
}