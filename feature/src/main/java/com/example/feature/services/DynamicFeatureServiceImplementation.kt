package com.example.feature.services

import android.util.Log

class DynamicFeatureServiceImplementation : DynamicFeatureService {
    override fun callDynamicFeatureService() {
        Log.d("DynamicFeatureService", "instance ${System.identityHashCode(this)}")
    }
}