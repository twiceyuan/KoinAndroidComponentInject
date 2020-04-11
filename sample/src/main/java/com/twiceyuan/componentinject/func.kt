package com.twiceyuan.componentinject

import android.app.Activity
import android.content.Context
import android.content.Intent

inline fun <reified T: Activity> Context.start() {
    startActivity(Intent(this, T::class.java))
}