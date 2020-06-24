package com.twiceyuan.componentinject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.twiceyuan.componentinject.ModuleOne
import com.twiceyuan.componentinject.R
import com.twiceyuan.componentinject.start
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val moduleOne: ModuleOne by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_custom_scope.setOnClickListener { start<CustomScopeActivity>() }
        btn_lifecycle_scope.setOnClickListener { start<LifecycleScopeActivity>() }

        moduleOne.callModuleTwoAction()
    }
}