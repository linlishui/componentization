// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.huitao.version") apply (false)
}

buildscript {
    //这里需要和version module中的kotlin版本统一，实际测试中如果不统一好像编译不通过
    val kotlinVersion by extra("1.4.32")
    val android by extra("com.android.tools.build:gradle:4.1.2")
    val kotlin_version by extra("1.4.32")
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        //kotlin的写法
        classpath(android)
        classpath(kotlin(module = "gradle-plugin", version = kotlinVersion))
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {

    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        jcenter()

    }
}

subprojects {
    // 子项目统一应用插件
    project.apply(plugin = "com.huitao.version")
    when (name) {
        //判断如果module是app则引入com.android.application插件
        "app" -> apply(plugin = "com.android.application")
        //如果不是则引入com.android.library插件，这里可以灵活编写
        else -> apply(plugin = "com.android.library")
    }
}
tasks.register<Delete>("clean") {
    delete(buildDir)
}