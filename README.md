# 🎓 EduTrack - Student Management System

<p align="center">
  <strong>A Modern Student Management Application</strong>
</p>

<p align="center">
  Manage student records easily, quickly, and efficiently.
</p>

---

## 📱 About The Project

**EduTrack** is a Student Management System developed to simplify the process of managing student information digitally.

The application provides a clean and user-friendly interface where users can add, view, search, update, and delete student records.

The main purpose of this project is to provide an efficient alternative to manual student record management.

---

## ✨ Features

### 👨‍🎓 Student Management

-  Add new students
-  View all registered students
-  Search students
-  Update student information
-  Delete student records
-  Delete student records when required

### 🔎 Search

Students can be searched using:

- Student name
- Email address
- Phone number

### 🎨 User Interface

- Modern Material 3 design
- Clean and simple interface
- Easy navigation
- Student management dashboard
- Bottom navigation
- Modern cards and buttons
- Responsive mobile layout

---

## 📋 Student Information

Each student record contains the following information:

| Field | Description |
|------|-------------|
|  Student ID | Unique identifier for each student |
|  Name | Student's full name |
|  Email | Student's email address |
|  Phone | Student's phone number |

---

## 🛠️ Technologies Used

| Technology | Purpose |
|-----------|---------|
| **Kotlin** | Application development |
| **Android Studio** | Development environment |
| **Jetpack Compose** | User interface |
| **Material 3** | Modern UI components |
| **SQLite** | Local database |
| **Android SDK** | Android application development |
| **Git** | Version control |
| **GitHub** | Source code hosting |

---

## 🏗️ Architecture

The application is organized into separate components for better maintainability.

```text
EduTrack_App104/
│
├── app/
│   │
│   └── src/
│       │
│       └── main/
│           │
│           ├── java/
│           │   │
│           │   └── com.example.myapplication/
│           │       │
│           │       ├── database/
│           │       │   └── DatabaseHelper.kt
│           │       │
│           │       ├── model/
│           │       │   └── Student.kt
│           │       │
│           │       └── MainActivity.kt
│           │
│           └── res/
│
├── gradle/
│
├── build.gradle.kts
├── gradle.properties
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
└── README.md
```

---

## 💾 Database

EduTrack uses **SQLite** as a local database for storing student information.

### Database Table

The application contains a `students` table.

```text
students
│
├── id
├── name
├── email
└── phone
```

### Database Operations

The application supports complete CRUD operations:

### Create

Add a new student to the database.

### Read

Retrieve and display all registered students.

### Update

Modify an existing student's information.

### Delete

Remove a student from the database.

### Search

Search student records using name, email, or phone number.

---

## 🔄 Application Flow

```text
                ┌───────────────┐
                │   Open App    │
                └───────┬───────┘
                        │
                        ▼
                ┌───────────────┐
                │     Home      │
                └───────┬───────┘
                        │
          ┌─────────────┼─────────────┐
          │             │             │
          ▼             ▼             ▼
     Add Student   Student List    Search
          │             │             │
          ▼             ▼             ▼
       Save        View Details    Find Student
          │             │             │
          └─────────────┼─────────────┘
                        │
                        ▼
                Edit / Delete
```

---

## 🚀 How To Run

### Requirements

Before running the project, make sure you have:

- Android Studio
- Android SDK
- JDK 11 or compatible JDK
- Android device or Android Emulator

### Steps

#### 1. Clone the Repository

```bash
git clone https://github.com/cit-23-02-0104-creator/EduTrack_App104.git
```

#### 2. Open the Project

Open the downloaded project using **Android Studio**.

#### 3. Gradle Sync

Allow Android Studio to download the required dependencies and complete Gradle synchronization.

#### 4. Connect a Device

You can either:

- Connect a physical Android device
- Use an Android Emulator

#### 5. Run the Application

Click:

```text
Run ▶
```

The EduTrack application will be installed and launched on the selected device.

---

## 📦 Build APK

To generate an APK from Android Studio:

```text
Build
   ↓
Generate App Bundles or APKs
   ↓
Generate APKs
```

The generated APK can be used to install the application on an Android device.

---

## 🎯 Project Objectives

The main objectives of EduTrack are:

- Reduce manual student record management
- Provide quick access to student information
- Make student searching easier
- Provide simple CRUD functionality
- Store student information securely in a local database
- Provide a modern and user-friendly interface
- Improve efficiency when managing student records

---

## 🌟 Advantages

- Simple to use
- Fast student searching
- Easy student registration
- Easy editing and deletion
- Local data storage
- Clean user interface
- Suitable for small-scale student management
- Easy to maintain and extend

---

## 🔮 Future Improvements

The following features can be added in future versions:

-  User authentication
-  Admin login
-  Student login
-  Cloud database
-  Firebase integration
-  Advanced analytics
-  Student performance reports
-  Export student records
-  Generate PDF reports
-  Notifications
-  Dark mode
-  Student profile pictures
-  Online synchronization
-  Role-based access control

---

## 🧪 Testing

The application can be tested using the following operations:

| Test | Expected Result |
|------|-----------------|
| Add Student | Student is saved successfully |
| View Students | All saved students are displayed |
| Search Student | Matching students are displayed |
| Update Student | Student information is updated |
| Delete Student | Selected student is removed |
| Empty Search | All students are displayed |
| Invalid Input | User is prevented from saving incomplete information |

---

## 🔒 Data Storage

Student information is stored locally using SQLite.

The application database contains:

```text
StudentManagement.db
```

The database automatically creates the required student table when the application is initialized.

---

## 📸 Screenshots

Add screenshots of the application here.

### Home Screen

```text
Add your Home Screen screenshot here
```

### Student List

```text
Add your Student List screenshot here
```

### Add Student

```text
Add your Add Student screenshot here
```

### Search Student

```text
Add your Search Student screenshot here
```

### Edit Student

```text
Add your Edit Student screenshot here
```

You can upload screenshots to the repository and add them using:

```markdown
![Home Screen](screenshots/home.png)
```

---

## 🌐 Project Repository

GitHub Repository:

**EduTrack_App104**

Repository URL:

https://github.com/cit-23-02-0104-creator/EduTrack_App104

---

## 👨‍💻 Developer

**CIT-23-02-0104**

Student Management System Project

---

## 📚 Project Type

**Android Application Development Project**

| Category | Details |
|----------|---------|
| **Application** | EduTrack |
| **Category** | Student Management System |
| **Platform** | Android |
| **Language** | Kotlin |
| **UI Framework** | Jetpack Compose |
| **Database** | SQLite |
| **Development Environment** | Android Studio |
| **Version Control** | Git & GitHub |

---

## ⭐ Acknowledgement

This project was developed as part of an academic Android application development project.

The project demonstrates practical implementation of:

- Android application development
- Kotlin programming
- Jetpack Compose UI
- SQLite database management
- CRUD operations
- Search functionality
- Git and GitHub version control

---

## 📄 License

This project is developed for educational and academic purposes.

---

<p align="center">
  🎓 <strong>EduTrack</strong>
  <br>
  <i>Smart • Simple • Efficient</i>
</p>
