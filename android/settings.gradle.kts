pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DroidLink"
include(":app")
include(":core:network")
include(":core:permissions")
include(":core:security")
include(":core:discovery")
include(":feature:clipboard:api")
include(":feature:clipboard:impl")
include(":feature:notifications:api")
include(":feature:notifications:impl")
include(":feature:files:api")
include(":feature:files:impl")
include(":feature:screen:api")
include(":feature:screen:impl")
include(":feature:media:api")
include(":feature:media:impl")
include(":feature:calls:api")
include(":feature:calls:impl")
