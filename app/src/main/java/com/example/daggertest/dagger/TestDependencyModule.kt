package com.example.daggertest.dagger


import com.example.daggertest.services.TestB
import com.example.daggertest.services.TestBImplementation
import dagger.Module
import dagger.Provides

@Module
class TestDependencyModule {

    @Provides
    @TestScope
    fun provideTestB(): TestB = TestBImplementation()
}