package com.twiceyuan.android.component.inject

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.koin.android.scope.bindScope
import org.koin.android.scope.lifecycleScope
import org.koin.core.scope.Scope


fun <ActivityType : AppCompatActivity> ActivityType.setupActivityProvider(scope: Scope = lifecycleScope) {

    // Bind lifecycle if scope has customized
    if (scope != lifecycleScope) {
        bindScope(scope)
    }

    // Append instance to scope
    scope.append {
        scoped<Activity> {
            this@setupActivityProvider
        }
        scoped<AppCompatActivity> {
            this@setupActivityProvider
        }
    }
}

fun <FragmentType : Fragment> FragmentType.setupFragmentProvider(scope: Scope = lifecycleScope) {

    // Bind lifecycle if scope has customized
    if (scope != lifecycleScope) {
        bindScope(scope)
    }

    // Append instance to scope
    scope.append {
        scoped<Fragment> { this@setupFragmentProvider }
    }
}

fun Scope.currentActivity(): AppCompatActivity? = getOrNull<AppCompatActivity>()

fun Scope.currentFragment(): Fragment? = getOrNull<Fragment>()