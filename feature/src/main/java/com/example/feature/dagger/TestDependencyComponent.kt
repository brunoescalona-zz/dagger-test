package com.example.feature.dagger

import com.example.daggertest.dagger.TestComponent
import com.example.daggertest.services.TestC
import com.example.feature.ui.TestBroadcastReceiver
import dagger.Component

@TestScope
@Component(
    modules = [TestDependencyModule::class],
    dependencies = [TestComponent::class]
)
interface TestDependencyComponent {
    fun inject(receiver: TestBroadcastReceiver)

    fun testC(): TestC
}