# MovieApp
An android app built using [Jetpack Compose](https://developer.android.com/jetpack/compose) that consumes [TMDB API](https://developers.themoviedb.org/3/getting-started/introduction) to display the current Movies

![MovieAppDetailScreen](https://github.com/abdelhak4/MovieApp/assets/53873640/3b624237-c01d-4894-8190-0be6b5a4b07d)
![movieAppHomeScreen](https://github.com/abdelhak4/MovieApp/assets/53873640/0be13681-ba27-4a98-bc95-a4ee681042dc)


---
# Setup Requirements
First, obtain your API key from [TMDB](https://developers.themoviedb.org/3/getting-started/introduction) (use Access token auth instead of API key if not working) and add it to  `build.gradle(:app)`:
```bash
 buildConfigField(
            "String",
            "API_KEY",
            "\"Api_KEY_HERE\""
)
```

---
# Tech Stack
- [Architicture](https://developer.android.com/topic/architecture#recommended-app-arch) - I used the recommanded Architicture 
- [Jetpack Components](https://developer.android.com/jetpack)
     - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Designed to store and manage UI-related data in a lifecycle-conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
- [Moshi](https://github.com/square/moshi/) - Moshi is a modern JSON library for Android, Java, and Kotlin. It makes it easy to parse JSON into Java and Kotlin classes
- [OkHttp Logging Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - Logs HTTP request and response data.
- [Coil](https://github.com/coil-kt/coil) - An image-loading library for Android backed by Kotlin Coroutines.
- [Retrofit](https://github.com/square/retrofit) - A type-safe HTTP client for Android and the JVM
