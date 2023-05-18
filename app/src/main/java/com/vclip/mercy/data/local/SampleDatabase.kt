/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [SampleEntity::class], version = 1, exportSchema = false
)

abstract class SampleDatabase : RoomDatabase() {
    abstract val sampleDao: SampleDao
}