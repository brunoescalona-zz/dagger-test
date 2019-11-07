package com.example.daggertest.ui

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggertest.R
import com.example.daggertest.dagger.Injector
import com.example.daggertest.services.TestA
import com.example.daggertest.services.TestC

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var testC: TestC
    @Inject
    lateinit var testA: TestA

    private var receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.feature.MY_NOTIFICATION")

        Injector.testComponent.inject(this)

        receiver = Class.forName("com.example.feature.ui.TestBroadcastReceiver").newInstance() as BroadcastReceiver
        registerReceiver(receiver, intentFilter)

        fab.setOnClickListener {
            testC.testCFun()
            testA.testAFun()

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
