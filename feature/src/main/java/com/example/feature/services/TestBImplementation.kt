package com.example.feature.services

import android.util.Log

class TestBImplementation : TestB {
    override fun testBFun() {
        Log.d("TestB", "instance ${System.identityHashCode(this)}")
    }
}