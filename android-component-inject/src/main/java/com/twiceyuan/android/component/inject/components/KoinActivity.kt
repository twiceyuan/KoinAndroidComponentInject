package com.twiceyuan.android.component.inject.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.twiceyuan.android.component.inject.setupActivityProvider
import org.koin.android.scope.bindScope
import org.koin.android.scope.lifecycleScope
import org.koin.core.scope.Scope

abstract class KoinActivity: AppCompatActivity() {

    open val scope: Scope by lazy { lifecycleScope }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (scope != lifecycleScope) {
            bindScope(scope)
        }

        setupActivityProvider(scope)
    }
}