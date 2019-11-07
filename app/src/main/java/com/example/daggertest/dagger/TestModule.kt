package com.example.daggertest.dagger

import com.example.daggertest.services.TestC
import com.example.daggertest.services.TestA
import com.example.daggertest.services.TestAImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestModule {

    @Provides
    @Singleton
    fun provideTestA() : TestA = TestAImplementation()

    private var testCProvider: TestC?= null

    @Provides
    @Singleton
    fun provideTestC(testComponent: TestComponent) : TestC {
        if(testCProvider != null) return testCProvider as TestC

        val provider = Class.forName("com.example.daggertest.services.TestCImplementation\$Provider").kotlin.objectInstance as TestC.Provider
        return provider
            .get(testComponent)
            .also { testCProvider = it }
    }
}