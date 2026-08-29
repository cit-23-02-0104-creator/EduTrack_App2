package com.example.myapplication.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Students : Screen("students", "Students", Icons.Default.Person)
    object AddStudent : Screen("add_student", "Add", Icons.Default.Add)
    
    // Dynamic route for editing
    object EditStudent : Screen("edit_student/{studentId}", "Edit", Icons.Default.Person) {
        fun createRoute(studentId: Int) = "edit_student/$studentId"
    }
}
