package com.example.myapplication.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.myapplication.model.Student

/**
 * Database Helper Class for Student Management
 * Extends SQLiteOpenHelper to manage database creation and version management
 */
class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {

    companion object {
        private const val DATABASE_NAME = "StudentManagement.db"
        private const val DATABASE_VERSION = 1
        
        // Table name
        private const val TABLE_STUDENTS = "students"
        
        // Column names
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PHONE = "phone"
    }

    /**
     * Called when the database is created for the first time
     * Creates the students table with required fields
     */
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE $TABLE_STUDENTS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT NOT NULL,
                $COLUMN_EMAIL TEXT NOT NULL,
                $COLUMN_PHONE TEXT NOT NULL
            )
        """.trimIndent()
        db?.execSQL(createTableQuery)
    }

    /**
     * Called when the database needs to be upgraded
     * Handles schema changes during version upgrades
     */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_STUDENTS")
        onCreate(db)
    }

    /**
     * INSERT: Add a new student to the database
     * @param student Student object containing student data
     * @return The row ID of the newly inserted student, or -1 if insertion failed
     */
    fun insertStudent(student: Student): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, student.name)
            put(COLUMN_EMAIL, student.email)
            put(COLUMN_PHONE, student.phone)
        }
        return db.insert(TABLE_STUDENTS, null, values)
    }

    /**
     * READ: Get all students from the database
     * @return List of all Student objects in the database
     */
    fun getAllStudents(): List<Student> {
        val students = mutableListOf<Student>()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_STUDENTS ORDER BY $COLUMN_ID DESC"
        
        val cursor = db.rawQuery(query, null)
        
        try {
            if (cursor.moveToFirst()) {
                do {
                    val student = Student(
                        id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                        name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                        email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)),
                        phone = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE))
                    )
                    students.add(student)
                } while (cursor.moveToNext())
            }
        } finally {
            cursor.close()
        }
        
        return students
    }

    /**
     * UPDATE: Modify an existing student's information
     * @param student Student object with updated data (must include valid ID)
     * @return Number of rows affected (1 if successful, 0 if student not found)
     */
    fun updateStudent(student: Student): Int {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, student.name)
            put(COLUMN_EMAIL, student.email)
            put(COLUMN_PHONE, student.phone)
        }
        
        val selection = "$COLUMN_ID = ?"
        val selectionArgs = arrayOf(student.id.toString())
        
        return db.update(TABLE_STUDENTS, values, selection, selectionArgs)
    }

    /**
     * DELETE: Remove a student from the database by ID
     * @param id The unique identifier of the student to delete
     * @return Number of rows affected (1 if successful, 0 if student not found)
     */
    fun deleteStudent(id: Int): Int {
        val db = this.writableDatabase
        val selection = "$COLUMN_ID = ?"
        val selectionArgs = arrayOf(id.toString())
        return db.delete(TABLE_STUDENTS, selection, selectionArgs)
    }

    /**
     * DELETE ALL: Remove all students from the database
     * Useful for clearing all data
     */
    fun deleteAllStudents(): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_STUDENTS, null, null)
    }

    /**
     * Search students by name (Bonus feature)
     * @param query Search text to match against student names
     * @return List of matching Student objects
     */
    fun searchStudents(query: String): List<Student> {
        val students = mutableListOf<Student>()
        val db = this.readableDatabase
        val searchQuery = "SELECT * FROM $TABLE_STUDENTS WHERE $COLUMN_NAME LIKE ? OR $COLUMN_EMAIL LIKE ? OR $COLUMN_PHONE LIKE ? ORDER BY $COLUMN_ID DESC"
        
        val term = "%$query%"
        val cursor = db.rawQuery(searchQuery, arrayOf(term, term, term))
        
        try {
            if (cursor.moveToFirst()) {
                do {
                    val student = Student(
                        id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                        name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                        email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)),
                        phone = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE))
                    )
                    students.add(student)
                } while (cursor.moveToNext())
            }
        } finally {
            cursor.close()
        }
        
        return students
    }
    @Deprecated("Use searchStudents() instead")
    fun searchStudentsByName(query: String): List<Student> = searchStudents(query)

}
