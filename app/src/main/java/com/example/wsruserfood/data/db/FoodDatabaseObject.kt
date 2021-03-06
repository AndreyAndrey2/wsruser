package com.example.wsruserfood.data.db

import android.content.Context
import androidx.room.Room
import com.example.wsruserfood.data.db.FoodDatabase

object FoodDatabaseObject {

    private lateinit var db: FoodDatabase

    fun createDatabase(context: Context) {
        db = Room.databaseBuilder(
            context,
            FoodDatabase::class.java,
            FoodDatabase.DATABASE_NAME
        ).build()
    }

    fun getFoodDao() = db.foodDao()
}