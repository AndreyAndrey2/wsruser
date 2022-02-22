package com.example.wsruserfood.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.wsruserfood.data.db.entity.DishEntity
import com.example.wsruserfood.data.db.entity.VersionsEntity


@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setFood(dish: DishEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setVersions(versions: VersionsEntity)

    @Query("SELECT * FROM versions")
    suspend fun getVersions(): VersionsEntity?
}