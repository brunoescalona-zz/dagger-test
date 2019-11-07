package com.example.daggertest.dagger

import com.example.daggertest.services.TestC
import com.example.daggertest.ui.Main2Activity
import dagger.Component

@TestScope
@Component(
    modules = [
        TestDependencyModule::class,
        BoundTestDependencyModule::class
    ],
    dependencies = [TestComponent::class]
)
interface TestDependencyComponent {
    fun inject(activity: Main2Activity)

    fun testC(): TestC
}