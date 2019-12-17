package com.example.mvvm_dagger_kotlin_3_10_19.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    @field:PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val pass: String
)