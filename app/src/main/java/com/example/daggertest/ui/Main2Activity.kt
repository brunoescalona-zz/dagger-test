package com.example.daggertest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggertest.R
import com.example.daggertest.dagger.Injector
import com.example.daggertest.services.TestA
import com.example.daggertest.services.TestB
import kotlinx.android.synthetic.main.activity_main2.*
import javax.inject.Inject

class Main2Activity : AppCompatActivity() {

    @Inject
    lateinit var testB: TestB
    @Inject
    lateinit var testA: TestA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        Injector.testDependencyComponent.inject(this)

        fab.setOnClickListener { view ->
            testB.testBFun()
            testA.testAFun()
        }
    }

}
