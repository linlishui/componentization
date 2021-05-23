// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.huitao.version") apply (false)
}

buildscript {
    val kotlinVersion by extra("1.4.32")
    val android by extra("com.android.tools.build:gradle:4.1.2")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(android)
        classpath(kotlin(module = "gradle-plugin", version = kotlinVersion))
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {

    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}

subprojects {
    // 子项目统一应用插件
    project.apply(plugin = "com.huitao.version")
    when (name) {
        "app" -> apply(plugin = "com.android.application")
        else -> apply(plugin = "com.android.library")
    }
}
tasks.register<Delete>("clean") {
    delete(buildDir)
}