package com.example.mvvm_dagger_kotlin_3_10_19.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @get:Query("SELECT * FROM User")
    val getAllUser:List<User>

    @Insert
    fun insertAll(vararg user: User)
}