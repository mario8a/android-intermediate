// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    // Se añade este para añadir kpt dagger
    id ("com.google.dagger.hilt.android") version "2.48" apply false
}