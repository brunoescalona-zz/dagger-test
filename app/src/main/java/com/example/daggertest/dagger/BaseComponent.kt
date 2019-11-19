package com.example.daggertest.dagger

import com.example.daggertest.services.BaseService
import com.example.daggertest.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BaseModule::class])
interface BaseComponent {
    fun inject(activity: MainActivity)

    fun provideBaseService() : BaseService
}