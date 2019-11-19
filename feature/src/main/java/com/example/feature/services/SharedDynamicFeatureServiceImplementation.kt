package com.example.feature.services

import android.util.Log
import com.example.daggertest.dagger.BaseComponent
import com.example.daggertest.services.SharedDynamicFeatureService
import com.example.feature.dagger.DaggerDynamicFeatureComponent
import com.example.feature.dagger.DynamicFeatureInjector
import javax.inject.Inject

class SharedDynamicFeatureServiceImplementation @Inject constructor(
    private val dynamicFeatureService: DynamicFeatureService
) : SharedDynamicFeatureService {
    override fun callSharedDynamicFeatureService() {
        dynamicFeatureService.callDynamicFeatureService()
        Log.d("SharedDynamicFeatureService", "instance ${System.identityHashCode(this)}")
    }

    companion object Provider : SharedDynamicFeatureService.Provider {
        override fun get(baseComponent: BaseComponent): SharedDynamicFeatureService {
            return DynamicFeatureInjector.dynamicFeatureComponent.getSharedDynamicFeatureService()
        }
    }
}