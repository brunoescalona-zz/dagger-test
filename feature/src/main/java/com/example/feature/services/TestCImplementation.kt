package com.example.feature.services

import android.util.Log
import com.example.daggertest.dagger.TestComponent
import com.example.daggertest.services.TestC
import com.example.feature.dagger.DaggerTestDependencyComponent
import javax.inject.Inject

class TestCImplementation @Inject constructor(
    private val testB: TestB
) : TestC {
    override fun testCFun() {
        testB.testBFun()
        Log.d("TestC", "instance ${System.identityHashCode(this)}")
    }

    companion object Provider : TestC.Provider {
        override fun get(testComponent: TestComponent): TestC {
            return DaggerTestDependencyComponent
                .builder()
                .testComponent(testComponent)
                .build()
                .testC()
        }
    }
}