package com.example.myapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.myapplication.database.DatabaseHelper
import com.example.myapplication.model.Student

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditStudentScreen(
    dbHelper: DatabaseHelper,
    studentId: Int? = null,
    onBack: () -> Unit,
    onSuccess: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var showDeleteDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val isEditMode = studentId != null

    LaunchedEffect(studentId) {
        if (isEditMode) {
            val student = dbHelper.getAllStudents().find { it.id == studentId }
            student?.let {
                name = it.name
                email = it.email
                phone = it.phone
            }
        }
    }

    val emailValid = email.isBlank() || android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()
    val phoneValid = phone.isBlank() || phone.trim().matches(Regex("^[0-9+()\\- ]{7,20}$"))
    val formValid = name.trim().length >= 2 && emailValid && phoneValid && email.isNotBlank() && phone.isNotBlank()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (isEditMode) "Edit Student" else "New Student", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    if (isEditMode) {
                        IconButton(onClick = { showDeleteDialog = true }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete", tint = MaterialTheme.colorScheme.error)
                        }
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(80.dp),
                shape = ShapeDefaults.ExtraLarge,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = if (name.isNotBlank()) name.first().uppercase() else "?",
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Full Name") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = name.isNotBlank() && name.trim().length < 2
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                isError = !emailValid
            )

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone Number") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                isError = !phoneValid
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val student = Student(
                        id = studentId ?: 0,
                        name = name.trim(),
                        email = email.trim(),
                        phone = phone.trim()
                    )
                    val success = if (isEditMode) {
                        dbHelper.updateStudent(student) > 0
                    } else {
                        dbHelper.insertStudent(student) != -1L
                    }

                    if (success) {
                        Toast.makeText(context, "Saved successfully", Toast.LENGTH_SHORT).show()
                        onSuccess()
                    } else {
                        Toast.makeText(context, "Failed to save", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                enabled = formValid,
                shape = ShapeDefaults.Medium
            ) {
                Icon(Icons.Default.Save, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(if (isEditMode) "UPDATE RECORD" else "SAVE STUDENT")
            }
        }
    }

    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text("Delete Student?") },
            text = { Text("Are you sure you want to remove $name? This action cannot be undone.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (studentId != null && dbHelper.deleteStudent(studentId) > 0) {
                            Toast.makeText(context, "Deleted successfully", Toast.LENGTH_SHORT).show()
                            onSuccess()
                        }
                    },
                    colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error)
                ) { Text("Delete") }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) { Text("Cancel") }
            }
        )
    }
}
