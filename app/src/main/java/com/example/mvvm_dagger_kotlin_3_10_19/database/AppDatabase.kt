package com.example.mvvm_dagger_kotlin_3_10_19.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun userDao(): UserDao
}