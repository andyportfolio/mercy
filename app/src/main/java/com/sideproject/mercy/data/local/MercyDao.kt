package com.sideproject.mercy.data.local

import androidx.room.*

@Dao
interface MercyDao {

    @Query("SELECT * FROM mercy_db")
    suspend fun getMercyEntity(): List<MercyEntity>

    @Query("SELECT * FROM mercy_db WHERE id = :id")
    suspend fun getMercyEntityById(id: Int): MercyEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMercyEntity(movie: MercyEntity)

    @Delete
    suspend fun deleteMercyEntity(movie: MercyEntity)
}