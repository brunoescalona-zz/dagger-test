package com.example.feature.dagger

import com.example.daggertest.dagger.BaseComponent
import com.example.daggertest.services.SharedDynamicFeatureService
import com.example.feature.ui.TestBroadcastReceiver
import dagger.Component

@DynamicFeatureScope
@Component(
    modules = [DynamicFeatureModule::class],
    dependencies = [BaseComponent::class]
)
interface DynamicFeatureComponent {
    fun inject(receiver: TestBroadcastReceiver)

    fun getSharedDynamicFeatureService(): SharedDynamicFeatureService
}