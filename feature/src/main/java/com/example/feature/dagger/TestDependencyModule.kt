package com.example.feature.dagger


import com.example.daggertest.services.TestC
import com.example.feature.services.TestB
import com.example.feature.services.TestBImplementation
import com.example.feature.services.TestCImplementation
import dagger.Module
import dagger.Provides

@Module
class TestDependencyModule {

    @Provides
    @TestScope
    fun provideTestB(): TestB = TestBImplementation()

    @Provides
    @TestScope
    fun provideTestC(testB: TestB): TestC = TestCImplementation(testB)
}