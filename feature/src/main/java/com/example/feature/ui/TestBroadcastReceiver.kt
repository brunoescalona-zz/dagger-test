package com.example.feature.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.daggertest.dagger.BaseInjector
import com.example.daggertest.services.BaseService
import com.example.feature.dagger.DynamicFeatureInjector
import com.example.feature.services.DynamicFeatureService
import javax.inject.Inject

class TestBroadcastReceiver : BroadcastReceiver() {

    @Inject
    lateinit var dynamicFeatureService: DynamicFeatureService
    @Inject
    lateinit var baseService: BaseService

    override fun onReceive(p0: Context?, p1: Intent?) {

        DynamicFeatureInjector.dynamicFeatureComponent.inject(this)

        Log.d("TestBroadcastReceiver", "onReceive")
        dynamicFeatureService.callDynamicFeatureService()
        baseService.callBaseService()
    }
}