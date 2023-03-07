# Joblogic Todo App

This application has been developed for demo purposes only, with the primary goal of showcasing the implementation of MVVM with Clean architecture

## Architecture

- Following Clean Architecture.
- MVVM Architecture.
- Repository pattern.
- Use Cases.
- Using Kotlin-KTS & buildSrc to handle project dependencies.

## Developed with

- Android Architecture Components
- LiveData
- ViewModel
- ViewBinding
- Dagger-Hilt
- Retrofit
- Kotlin Coroutines
- Jetpack Navigation
- Flow

## Note

For large Android applications with many screens and features, using the ***Package by Feature***a approach is a better choice. Each feature has its own module, containing its own view, view model, domain, repository, data source, etc. This improves modularity, making it easier to develop and test each feature independently, and add or remove features without affecting the entire codebase.