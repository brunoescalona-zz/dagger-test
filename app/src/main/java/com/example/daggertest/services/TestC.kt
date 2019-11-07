package com.example.daggertest.services

import com.example.daggertest.dagger.TestComponent

interface TestC {
    fun testCFun()

    interface Provider {
        fun get(testComponent: TestComponent): TestC
    }
}