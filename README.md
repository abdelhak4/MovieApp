# MovieApp
An android app built using [Jetpack Compose](https://developer.android.com/jetpack/compose) that consumes [TMDB API](https://developers.themoviedb.org/3/getting-started/introduction) to display the current Movies
---
# Setup Requirements
First, obtain your API key from [TMDB](https://developers.themoviedb.org/3/getting-started/introduction) and add it to  `build.gradle(:app)`:
```bash
 buildConfigField(
            "String",
            "API_KEY",
            "\"Api_KEY_HERE\""
)
```

---
# Tech Stack

- [MVVM Architecture](https://developer.android.com/topic/architecture) - A software architecture that removes the tight coupling between components. Most importantly, in this architecture, the children don't have the direct reference to the parent, they only have the reference by observables.
- - [Jetpack Components](https://developer.android.com/jetpack)
     - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
- [Moshi]([https://github.com/square/gson](https://github.com/square/moshi/)) - Moshi is a modern JSON library for Android, Java and Kotlin. It makes it easy to parse JSON into Java and Kotlin classes
- [OkHttp Logging Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - Logs HTTP request and response data.
- [Coil](https://github.com/coil-kt/coil) - An image loading library for Android backed by Kotlin Coroutines.

    
