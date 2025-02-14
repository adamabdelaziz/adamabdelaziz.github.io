rootProject.name = "ResumeWebsite2025"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google ()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google ()
        mavenCentral()
    }
}

include(":composeApp")