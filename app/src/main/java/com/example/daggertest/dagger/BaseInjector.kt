package com.example.daggertest.dagger

object BaseInjector {
    val baseComponent: BaseComponent = DaggerBaseComponent
        .builder()
        .build()

    /*val testDependencyComponent = DaggerTestDependencyComponent
        .builder()
        .baseComponent(baseComponent)
        .build()*/
}