package com.example.daggertest.ui

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.daggertest.R
import com.example.daggertest.dagger.BaseInjector
import com.example.daggertest.services.BaseService
import com.example.daggertest.services.SharedDynamicFeatureService

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedDynamicFeatureService: SharedDynamicFeatureService
    @Inject
    lateinit var baseService: BaseService

    private var receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.feature.MY_NOTIFICATION")

        BaseInjector.baseComponent.inject(this)


        receiver = Class.forName("com.example.feature.ui.TestBroadcastReceiver").newInstance() as BroadcastReceiver
        registerReceiver(receiver, intentFilter)

        fab.setOnClickListener {
            Log.d("MainActivity","fabClicked")
            sharedDynamicFeatureService.callSharedDynamicFeatureService()
            baseService.callBaseService()

            Intent().also { intent ->
                intent.action = "com.example.feature.MY_NOTIFICATION"
                sendBroadcast(intent)
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        receiver?.apply {
            unregisterReceiver(this)
        }
    }

}
