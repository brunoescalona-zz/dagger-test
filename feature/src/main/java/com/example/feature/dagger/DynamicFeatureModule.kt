package com.example.feature.dagger


import com.example.daggertest.services.SharedDynamicFeatureService
import com.example.feature.services.DynamicFeatureService
import com.example.feature.services.DynamicFeatureServiceImplementation
import com.example.feature.services.SharedDynamicFeatureServiceImplementation
import dagger.Module
import dagger.Provides

@Module
class DynamicFeatureModule {

    @Provides
    @DynamicFeatureScope
    fun provideTestB(): DynamicFeatureService = DynamicFeatureServiceImplementation()

    @Provides
    @DynamicFeatureScope
    fun provideTestC(dynamicFeatureService: DynamicFeatureService): SharedDynamicFeatureService = SharedDynamicFeatureServiceImplementation(dynamicFeatureService)
}