package com.example.daggertest.ui

import android.content.Intent
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        Injector.testComponent.inject(this)

        fab.setOnClickListener {
            testC.testCFun()
            testA.testAFun()
            startActivity(Intent(this, Main2Activity::class.java))
        }
    }

}
