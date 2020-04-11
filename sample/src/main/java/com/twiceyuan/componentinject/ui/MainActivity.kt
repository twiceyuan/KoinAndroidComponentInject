package com.twiceyuan.componentinject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.twiceyuan.componentinject.R
import com.twiceyuan.componentinject.start
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_custom_scope.setOnClickListener { start<CustomScopeActivity>() }
        btn_lifecycle_scope.setOnClickListener { start<LifecycleScopeActivity>() }
    }
}