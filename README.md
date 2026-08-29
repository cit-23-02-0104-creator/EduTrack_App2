# Student Management System 📚

An Android student management application built with **Kotlin**, **Jetpack Compose**, **Material 3**, and **SQLite**.

## Features

- Add student records
- View all students
- Update existing students
- Delete a selected student
- Clear all records with confirmation
- Search by name, email, or phone number
- Form validation for name, email, and phone
- Local SQLite database persistence
- Clean Material 3 user interface

## Tech Stack

- Kotlin
- Android Jetpack Compose
- Material 3
- SQLite / `SQLiteOpenHelper`
- Gradle Kotlin DSL

## Project Structure

```text
app/
└── src/main/java/com/example/myapplication/
    ├── MainActivity.kt
    ├── database/DatabaseHelper.kt
    ├── model/Student.kt
    └── ui/components/StudentCard.kt
```

## How to Run

1. Open the project in Android Studio.
2. Allow Gradle to sync and download required dependencies.
3. Connect an Android device or start an emulator.
4. Click **Run**.

Minimum Android version: **API 24 (Android 7.0)**.

## GitHub

Before pushing the project, make sure `local.properties` is not committed because it contains a machine-specific Android SDK path.

Suggested commands:

```bash
git init
git add .
git commit -m "Complete student management system"
git branch -M main
git remote add origin <YOUR_GITHUB_REPOSITORY_URL>
git push -u origin main
```

## Viva / Demonstration Flow

1. Add a student.
2. Show the record appearing in the list.
3. Search for the student.
4. Tap the record and update the details.
5. Select the record again and delete it.
6. Explain that data is stored locally using SQLite.
