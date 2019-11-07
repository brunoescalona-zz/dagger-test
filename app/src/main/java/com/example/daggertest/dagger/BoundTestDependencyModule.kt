package com.example.daggertest.dagger

import com.example.daggertest.services.TestCImplementation
import com.example.daggertest.services.TestC
import dagger.Binds
import dagger.Module

@Module
abstract class BoundTestDependencyModule {
    @Binds
    abstract fun bindTestC(implementation: TestCImplementation): TestC
}