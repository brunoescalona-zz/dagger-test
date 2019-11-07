package com.example.feature.dagger

import com.example.daggertest.dagger.TestComponent

object Injector {

    lateinit var testDependencyComponent: TestDependencyComponent

    @JvmStatic
    internal fun getTestDependencyComponent(testComponent: TestComponent): TestDependencyComponent {
        if (!::testDependencyComponent.isInitialized) {
            testDependencyComponent = DaggerTestDependencyComponent.builder()
                .testComponent(testComponent)
                .build()
        }
        return testDependencyComponent
    }
}