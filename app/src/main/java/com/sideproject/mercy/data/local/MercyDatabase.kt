package com.sideproject.mercy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MercyEntity::class], version = 1, exportSchema = false
)

abstract class MercyDatabase : RoomDatabase() {
    abstract val mercyDao: MercyDao
}