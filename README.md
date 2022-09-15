[![Android CI](https://github.com/Fbada006/TmdbTestApp/actions/workflows/build.yml/badge.svg?branch=master)](https://github.com/Fbada006/TmdbTestApp/actions/workflows/build.yml)

# TmdbTestApp

This is a simple application that is built using the Model-View-ViewModel (MVVM) architecture in 100% Kotlin. It gets
data from the [TMDB API](https://www.themoviedb.org/documentation/api) and displays a list
of movies to the user. On clicking an item, the app navigates to a details screen.

# Prerequisites

To run the app, make sure you have the following:

1. Android Studio Chipmunk | 2021.2.1 Patch 2 or higher
2. Go to the api above and save your free api key in the `local.properties` file using the
   format `tmdbApiKey="your-api-key"`. If you do not do this, the app will not run.

## Table of contents

- [Architecture](#architecture)
- [Libraries](#libraries)
- [Extras](#extras)

## Architecture

The app uses the MVVM architecure because it is a nice and simple architecture that makes testing and maintenance
easier.
It was also chosen because it is a popular choice meaning a new developer can pick it up easily making for smooth
transitions between teams. There is also the added
benefit of using a `ViewModel` to survive configuration changes. `Kotlin Flow` has been used extensively to monitor data
and state changes in the app making for a smooth user experience. Caching has been done using room, the `viewmodelscope`
while images use the caching
mechanism of the image loading library used, ie, `coil`

## Libraries

This app takes use of the following libraries:

- [Jetpack](https://developer.android.com/jetpack)🚀
    - [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI data to survive
      configuration changes and is lifecycle-aware
    - [Compose](https://developer.android.com/jetpack/compose) - Android’s modern toolkit for building native UI.
    - [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - Navigate between composables
      while taking advantage of the Navigation component’s infrastructure and features
    - [Room DB](https://developer.android.com/topic/libraries/architecture/room) - Fluent SQLite database access
    - [Paging](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) - Load and display small
      chunks of
      data at a time
- [Retrofit](https://square.github.io/retrofit/) - type safe http client with coroutines support
- [Moshi](https://github.com/square/moshi) - A modern JSON library for Android, Java and Kotlin
- [Dagger Hilt](https://dagger.dev/hilt/) - A fast dependency injector for Android and Java.
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) -
  logging HTTP request related data.
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines
- [Material Design](https://material.io/develop/android/docs/getting-started/) - build awesome beautiful UIs.🔥🔥
- [Coil](https://coil-kt.github.io/coil/compose/) - Hassle-free image loading with free caching
- [Timber](https://github.com/JakeWharton/timber) - A logger with a small, extensible API which provides utility on top
  of Android's normal Log class.
- [Truth](https://truth.dev/) - A library for performing assertions in tests

## Extras

#### CI-Pipeline

The app also uses GitHub actions to build the app and runs whenever a new pull request or merge to the `master` branch happens.
Note the creation of the fake `local.properties` file as one of the steps to avoid an error. Find the configuration in the `.github` folder in the `build.yml` file

#### Challenges

One of the biggest issues with the app is that I did not work with a UI designer, meaning the UI could use a lot of improvements. With more time, I would have used something like
Dribble to get a good design. There is also another challenge with the fact that `Jetpack Compose Navigation` has certain limitations making it difficult to debug in case of an error but these
are all problems that were surmounted by searching for information online and learning.

```
MIT License

Copyright (c) 2022 Ferdinand Bada

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```