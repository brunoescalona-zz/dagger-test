package com.example.daggertest.services

import com.example.daggertest.dagger.BaseComponent

interface SharedDynamicFeatureService {
    fun callSharedDynamicFeatureService()

    interface Provider {
        fun get(baseComponent: BaseComponent): SharedDynamicFeatureService
    }
}