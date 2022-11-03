# SimpleNewsApp
Simple android app trying to demonstrate the Multi-Module with MVVM and Jetpack components

Modularisation is done based in feature and then layer
- app
- core
- news-details(coming soon)
    - data
    - domain
    - presentation
- news-headline-data
- news-headline-domain


# News API
We using [NEWS API](https://newsapi.org/) to get data and show in app. Create your own `API Key` and replace `NEWS_API_KEY`  in `Constants.kt` present in `core` module.
```sh
const val API_KEY = "NEWS_API_KEY"
```

# Libraries
- [Jetpack](https://developer.android.com/jetpack)
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI data to survive configuration changes.
    - [View Binding](https://developer.android.com/topic/libraries/view-binding) - It generates a binding class for each XML layout file
    - [Navigation](https://developer.android.com/guide/navigation/) - Handle everything needed for navigation
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Notify views when underlying database changes
- [Retrofit](https://square.github.io/retrofit/) - type safe http client with coroutines support
- [Gson](https://github.com/google/gson) - A serialization/deserialization library to convert Objects into JSON and back
- [Hilt](https://dagger.dev/hilt/) - A fast dependency injector for Android.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines
- [Glide](https://github.com/bumptech/glide) - Fast and efficient image loading framework


# TODO
- [Paging](https://developer.android.com/topic/libraries/architecture/paging) - Load and display small chunks of data at a time
- news-details module 
