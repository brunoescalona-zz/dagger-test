package com.example.daggertest.services

import android.util.Log
import com.example.daggertest.dagger.DaggerTestComponent
import com.example.daggertest.dagger.DaggerTestDependencyComponent
import com.example.daggertest.dagger.TestComponent
import com.example.daggertest.services.TestB
import com.example.daggertest.services.TestC
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