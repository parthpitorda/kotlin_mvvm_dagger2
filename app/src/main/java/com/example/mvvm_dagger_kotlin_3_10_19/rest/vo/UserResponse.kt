package com.example.mvvm_dagger_kotlin_3_10_19.rest.vo

data class UserResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    open var data: List<Datum> = ArrayList<Datum>()
)

data class Datum(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)