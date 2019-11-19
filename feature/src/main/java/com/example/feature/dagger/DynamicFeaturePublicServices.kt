package com.example.feature.dagger

import com.example.daggertest.services.SharedDynamicFeatureService

object DynamicFeaturePublicServices {

    fun getSharedDynamicFeatureServiec() : SharedDynamicFeatureService {
        return DynamicFeatureInjector.dynamicFeatureComponent.getSharedDynamicFeatureService()
    }
}