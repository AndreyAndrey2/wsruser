package com.example.wsruserfood.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.wsruserfood.data.db.dao.FoodDao
import com.example.wsruserfood.data.db.dao.TypesConverter
import com.example.wsruserfood.data.db.entity.DishEntity
import com.example.wsruserfood.data.db.entity.VersionsEntity


@Database(
    entities = [DishEntity::class, VersionsEntity::class],
    version = FoodDatabase.VERSION,
    exportSchema = false
)
@TypeConverters(TypesConverter::class)
abstract class FoodDatabase : RoomDatabase() {

    abstract fun foodDao(): FoodDao

    companion object {
        const val DATABASE_NAME = "food-db"
        const val VERSION = 1
    }
}