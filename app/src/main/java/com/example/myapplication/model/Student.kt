package com.example.myapplication.model

/**
 * Data class representing a Student entity
 * Used to store and retrieve student information from SQLite database
 */
data class Student(
    val id: Int = 0,           // Unique identifier (auto-incremented in database)
    val name: String,          // Student's full name
    val email: String,         // Student's email address
    val phone: String          // Student's phone number
)
