# android-crew-jetpack-navigation-sample

Репозиторий с примером использования Jetpack Navigation Components созданый для доклада на Podlodka Android Crew #4

## План доклада

- Зависимости
- Основы навигации
  - Что такое NavHost. NavHostFragment
  - Что такое NavController
  - Что такое destinations
- Single activity
- Обновление UI с помошью NavigationUI
- Создаем граф навигации
  - Nested graphs
  - Global actions
  - [popUpTo, popUpToInclusive](https://developer.android.com/guide/navigation/navigation-navigate#pop)
- Редактирование графов навигации
- screen as the start destination
- Использование Safe Args
- OnBackPressedCallback
- [Up and Back are identical within your app's task, but The Up button never exits your app](https://developer.android.com/guide/navigation/navigation-principles#up_and_back_are_identical_within_your_apps_task)
- Использование разных backstack
- Использование разных NavController
- Отображение сообщений
- Animate transitions between destinations
  - Material Motion System

### О чем я не расскажу

- Kotlin DSL
- Тестирование

## Полездные материалы

- [Видео. Android Broadcast: Навигационная битва.](https://youtu.be/sDEoscFXL0k)
- [Gist. Android Broadcast: Навигационная битва. Navigation component](https://gist.github.com/Shipaaaa/48ced61d85f9368b52570bf07dc99b38)
- [Статья. Лицензия на вождение болида, или почему приложения должны быть Single-Activity](https://habr.com/ru/company/redmadrobot/blog/426617/)
- [Статья. Navigation Component-дзюцу, vol. 4 – Переоценка](https://habr.com/ru/company/hh/blog/535534/)
- [Библиотека. redmadrobot-android-ktx](https://github.com/RedMadRobot/redmadrobot-android-ktx)
  - [viewbinding-ktx](https://github.com/RedMadRobot/redmadrobot-android-ktx/tree/main/viewbinding-ktx)
  - [lifecycle-livedata-ktx](https://github.com/RedMadRobot/redmadrobot-android-ktx/tree/main/lifecycle-livedata-ktx)
- [Gist. NavigationExtensions.kt](https://github.com/android/architecture-components-samples/blob/main/NavigationAdvancedSample/app/src/main/java/com/example/android/navigationadvancedsample/NavigationExtensions.kt)
