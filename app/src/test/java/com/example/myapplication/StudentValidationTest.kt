package com.example.myapplication

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class StudentValidationTest {
    private val phoneRegex = Regex("^[0-9+()\\- ]{7,20}$")
    private val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

    @Test
    fun validEmail_isAccepted() {
        assertTrue(emailRegex.matches("student@example.com"))
    }

    @Test
    fun invalidEmail_isRejected() {
        assertFalse(emailRegex.matches("student@"))
    }

    @Test
    fun validPhone_isAccepted() {
        assertTrue(phoneRegex.matches("+94 77 123 4567"))
    }

    @Test
    fun invalidPhone_isRejected() {
        assertFalse(phoneRegex.matches("abc"))
    }
}
