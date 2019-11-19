package com.example.daggertest.dagger

import com.example.daggertest.services.SharedDynamicFeatureService
import com.example.daggertest.services.BaseService
import com.example.daggertest.services.BaseServiceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule {

    @Provides
    @Singleton
    fun provideTestA() : BaseService = BaseServiceImplementation()

    private var sharedDynamicFeatureServiceProvider: SharedDynamicFeatureService?= null

    @Provides
    @Singleton
    fun provideTestC(baseComponent: BaseComponent) : SharedDynamicFeatureService {
        if(sharedDynamicFeatureServiceProvider != null) return sharedDynamicFeatureServiceProvider as SharedDynamicFeatureService

        /* still need to find a way to load the thing without kotlin reflection
        val provider = Class
            .forName("com.example.feature.services.SharedDynamicFeatureServiceImplementation\$Provider")
            .getDeclaredField("INSTANCE")
            .get(null)  as SharedDynamicFeatureService.Provider
         */


        //val dynamicFeaturePublicServices = Class.forName("com.example.feature.dagger.DynamicFeaturePublicServices").getDeclaredField("INSTANCE").get(null) as DynamicFeaturePublicServices

        val provider = Class.forName("com.example.feature.services.SharedDynamicFeatureServiceImplementation\$Provider").kotlin.objectInstance as SharedDynamicFeatureService.Provider
        return provider
            .get(baseComponent)
            .also { sharedDynamicFeatureServiceProvider = it }
    }
}