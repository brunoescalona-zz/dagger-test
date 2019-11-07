package com.example.daggertest.dagger

object Injector {
    val testComponent = DaggerTestComponent
        .builder()
        .build()

    /*val testDependencyComponent = DaggerTestDependencyComponent
        .builder()
        .testComponent(testComponent)
        .build()*/
}