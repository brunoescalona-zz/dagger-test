package com.example.daggertest.services

import android.util.Log

class BaseServiceImplementation : BaseService {
    override fun callBaseService(){
        Log.d("BaseService", "instance ${System.identityHashCode(this)}")
    }
}