# GitHub User Information App

Welcome to the **GitHub User Information App** repository! This app demonstrates how to fetch, store, and display GitHub user data with support for both **online** and **offline** scenarios. Below you will find a detailed explanation of its purpose, architecture, and how to get started.

---

## Table of Contents

1. [Introduction](#introduction)
2. [Key Features](#key-features)
3. [Architecture and MVI Framework](#architecture-and-mvi-framework)
4. [Tech Stack](#tech-stack)
5. [Offline Support (Single Source of Truth)](#offline-support-single-source-of-truth)
6. [App Screens](#app-screens)
7. [Usage](#usage)
8. [Improvements](#improvements)
9. [Additional Notes](#additional-notes)

---

## Introduction

This project is a mobile application designed to retrieve and display GitHub user information using the [GitHub User API](https://docs.github.com/en/rest/users/users). The primary goal is to offer a **list view** of users and a **detailed view** of an individual user's profile and activities. By leveraging modern Android frameworks and libraries, this application is **scalable**, **maintainable**, and follows **clean architecture** principles with an **MVI (Model-View-Intent)** pattern.

**Primary user expectations**:
- **List of GitHub users**: The user can browse through all or specific sets of GitHub users.
- **Detailed profile**: The user can tap on any user to see more details like their profile information and user activities.

---

## Key Features

1. **Modern Android Libraries**: Built entirely with the latest Android tech (Jetpack Compose, Hilt, Koin, Retrofit, Room, Navigation Compose, etc.).
2. **Clean Architecture + MVI**:
    - Encourages code organization and reusability.
    - Makes it easier for multiple developers to collaborate and follow the same coding practices.
3. **Offline Support**:
    - Data fetched from remote APIs is stored locally in a Room database.
    - The app always prefers the local database as the **single source of truth**.
4. **Scalability**:
    - Modular code allows adding more features without major refactoring.
5. **Responsive UI**:
    - Uses Jetpack Compose to build a responsive, state-driven user interface.
6. **Easy Maintenance**:
    - Well-structured code with a clear separation of concerns.
    - Built-in dependency injection (Hilt / Koin) for simpler code management.
7. **Navigation Compose**:
    - Seamless, type-safe navigation in a Compose-only environment.

---

## Architecture and MVI Framework

This project follows **Clean Architecture** principles combined with the **MVI (Model-View-Intent)** pattern:

- **Domain Layer**: Contains the business logic, use cases, and entity definitions.
- **Data Layer**: Manages data fetching and storage using `Retrofit` and `Room`:
    - **Repository**: Orchestrates data operations between network (Retrofit) and local DB (Room).
    - **API Services**: Handles all network calls to GitHub User API.
    - **Local Data**: Uses Room for local caching to support offline mode.
- **Presentation Layer (UI)**:
    - **Model-View-Intent (MVI)**: Provides a unidirectional data flow, making state management easier.
    - **Jetpack Compose**: Builds composable UI screens that react to state changes.

### Why MVI?

1. **Predictable State**: Since the data flow is unidirectional, any changes in UI state are trackable, making debugging simpler.
2. **Scalable Approach**: Multiple developers can add new features without accidentally breaking the existing flow.
3. **Better Separation of Concerns**: Intent (user actions), View (UI state), and Model (data) are well-defined.

---

## Tech Stack

- **Language**: Kotlin
- **UI**: [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Dependency Injection**: [Hilt](https://developer.android.com/training/dependency-injection/hilt) and/or [Koin](https://insert-koin.io/)
- **Network**: [Retrofit](https://square.github.io/retrofit/) + [OkHttp](https://square.github.io/okhttp/)
- **Database**: [Room](https://developer.android.com/training/data-storage/room)
- **Navigation**: [Navigation Compose](https://developer.android.com/jetpack/compose/navigation)
- **Architecture**: Clean Architecture + MVI
- **Build Tool**: Gradle

---

## Offline Support (Single Source of Truth)

One of the significant highlights of this app is **offline support**:

1. **Fetch remote data** using Retrofit from the GitHub API.
2. **Save data** in the local Room database immediately after fetching.
3. **Display data** from the local database. This means even if your device goes offline, you still see the previously fetched data.
4. **Automatic syncing**: When the app regains network connectivity, it can refresh data in the background.

---

## App Screens

1. **List View Screen**  
   Displays a list of GitHub users.
    - On launch, the app fetches users from remote, stores them in the local Room DB, and shows them on the UI.
    - Supports scrolling, searching (optional), and/or pagination.

2. **Detail View Screen**  
   Shows the detailed profile of a selected GitHub user.
    - Retrieves relevant user details (avatar, bio, location, public repositories, etc.).
    - Optionally displays their latest activities or repos.

**Screenshots (Placeholder):**  
[Image 1](https://private-user-images.githubusercontent.com/30040958/418765401-b8b58eb9-fb76-4d97-8bab-32a0b890fd1d.png?jwt=eyJhbGci...)
[Image 2](https://private-user-images.githubusercontent.com/30040958/418765402-4ddc98ad-26ab-41d1-826e-d64ffa403038.png?jwt=eyJhbGci...)

---

## Usage

1. **Clone the Repository**
   ```bash
   git clone https://github.com/abhikommen/bitflyer-github.git
   cd yourrepo
   ```
2. **Open in Android Studio**
    - Open the project folder in [Android Studio](https://developer.android.com/studio).
    - Let Gradle sync.

3. **Configure**
    - The default GitHub API base URL is set in the Retrofit module.
    - If you need any GitHub personal access token (for higher rate limits), you can add it to your gradle properties or environment variables.

4. **Build and Run**
    - Select a device or emulator, then click **Run** in Android Studio.
    - The app will install and launch on your chosen device/emulator.

---

## Improvements

Here are some potential improvements and additional features we could implement:

1. **ProGuard / R8**
    - Shrink the APK size and obfuscate code for production releases.

2. **Comprehensive Test Cases**
    - **Unit Tests**: For repositories, use cases, view models.
    - **UI Tests**: Automated tests for the Compose screens using the AndroidX test libraries.

3. **Add Favorite User Functionality**
    - Let users “favorite” or bookmark specific GitHub users.
    - Store favorites in the local Room DB to sync across sessions.

4. **Improved Internet Reactivity**
    - Monitor network changes to automatically refresh data or show offline UI states.
    - Possibly show a “No Connection” banner when the network is unavailable.

5. **Better Error Handling**
    - Implement custom error screens or dialogs for different failure scenarios (e.g., 404 Not Found, 403 Rate Limited).

6. **Pagination**
    - Implement pagination in the list view (e.g., using Paging 3 or a similar mechanism) to handle large lists of users more efficiently.

7. **User Searching**
    - Allow searching specific GitHub users by username.

8. **Dark Mode**
    - Provide theme toggling for users who prefer dark mode.

9. **CI/CD Pipeline**
    - Set up GitHub Actions or another CI service to run tests, code analysis, and produce builds automatically.

---

## Additional Notes

- **License**: This project’s license can be specified based on your preference (e.g., MIT, Apache 2.0, etc.).
- **Collaboration**: Contributions are welcome! Please submit pull requests or issues if you have any improvements or bug fixes.
- **Contact**: For any inquiries, reach out via email or open an issue in this repository.

---

**Thank you for checking out the GitHub User Information App!**  
Feel free to explore, contribute, or provide feedback to make this app even better.