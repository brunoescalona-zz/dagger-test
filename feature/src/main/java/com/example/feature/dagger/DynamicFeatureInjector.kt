package com.example.feature.dagger

import com.example.daggertest.dagger.BaseInjector

object DynamicFeatureInjector {

    val dynamicFeatureComponent: DynamicFeatureComponent by lazy {
        DaggerDynamicFeatureComponent.builder()
            .baseComponent(BaseInjector.baseComponent)
            .build()
    }

}