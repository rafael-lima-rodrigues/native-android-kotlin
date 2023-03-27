package com.example.myfirstapp

data class User(
    val name: String,
    val height: Float,
    val weight: Float,
    val age: Int,
    val bmi: Float): java.io.Serializable
