package com.example.daggertest.dagger

import com.example.daggertest.services.TestA
import com.example.daggertest.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestModule::class])
interface TestComponent {
    fun inject(activity: MainActivity)

    fun provideTestA() : TestA
}