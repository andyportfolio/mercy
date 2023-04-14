package com.sideproject.mercy.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mercy_db")
data class MercyEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val imageUrl: String
)