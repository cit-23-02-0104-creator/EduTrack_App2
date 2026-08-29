# Multi-Screen Student Management App Implementation Plan

Refactor the current single-page application into a multi-screen app with a dashboard, dedicated management screens, and bottom navigation.

## User Review Required

> [!IMPORTANT]
> The app will transition from a single-column layout to a multi-screen architecture using Jetpack Navigation. This will change the user flow to be more organized and professional.

## Proposed Changes

### [Dependencies]

#### [MODIFY] [libs.versions.toml](file:///C:/Users/jayani/Downloads/Student-Management-System-GitHub-Ready/Student-management-app-main/gradle/libs.versions.toml)
Add `androidx-navigation-compose` to versions and libraries.

#### [MODIFY] [build.gradle.kts (app)](file:///C:/Users/jayani/Downloads/Student-Management-System-GitHub-Ready/Student-management-app-main/app/build.gradle.kts)
Add the navigation dependency to the project.

---

### [Architecture & Components]

#### [NEW] [Screen.kt](file:///C:/Users/jayani/Downloads/Student-Management-System-GitHub-Ready/Student-management-app-main/app/src/main/java/com/example/myapplication/ui/navigation/Screen.kt)
Define routes for Home, Students, and Add.

#### [NEW] [HomeScreen.kt](file:///C:/Users/jayani/Downloads/Student-Management-System-GitHub-Ready/Student-management-app-main/app/src/main/java/com/example/myapplication/ui/screens/HomeScreen.kt)
Implement the dashboard with "Total Students", "Quick Actions", and "Recent Students".

#### [NEW] [StudentsScreen.kt](file:///C:/Users/jayani/Downloads/Student-Management-System-GitHub-Ready/Student-management-app-main/app/src/main/java/com/example/myapplication/ui/screens/StudentsScreen.kt)
Migrate the list and search functionality here.

#### [NEW] [AddEditStudentScreen.kt](file:///C:/Users/jayani/Downloads/Student-Management-System-GitHub-Ready/Student-management-app-main/app/src/main/java/com/example/myapplication/ui/screens/AddEditStudentScreen.kt)
Migrate the form functionality here, supporting both Add and Edit modes.

---

### [Main UI Shell]

#### [MODIFY] [MainActivity.kt](file:///C:/Users/jayani/Downloads/Student-Management-System-GitHub-Ready/Student-management-app-main/app/src/main/java/com/example/myapplication/MainActivity.kt)
Implement the `Scaffold` with `NavigationBar` and `NavHost` to coordinate between screens.

## Verification Plan

### Automated Tests
- Run `app:assembleDebug` to verify build integrity.

### Manual Verification
- Deploy to device/emulator.
- Verify bottom navigation switches between screens.
- Verify "Total Students" on Home updates after adding a student.
- Verify Search works correctly on the Students screen.
- Verify the Edit flow correctly navigates to the form with pre-filled data.
