package com.example.feature.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.daggertest.services.TestA
import com.example.feature.dagger.Injector
import com.example.feature.services.TestB
import javax.inject.Inject

class TestBroadcastReceiver: BroadcastReceiver() {

    @Inject
    lateinit var testB: TestB
    @Inject
    lateinit var testA: TestA

    override fun onReceive(p0: Context?, p1: Intent?) {

        Injector.getTestDependencyComponent(com.example.daggertest.dagger.Injector.testComponent).inject(this)

        testB.testBFun()
        testA.testAFun()
    }
}