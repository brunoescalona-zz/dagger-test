package com.example.daggertest.services

import android.util.Log

class TestAImplementation : TestA {
    override fun testAFun(){
        Log.d("TestA", "instance ${System.identityHashCode(this)}")
    }
}