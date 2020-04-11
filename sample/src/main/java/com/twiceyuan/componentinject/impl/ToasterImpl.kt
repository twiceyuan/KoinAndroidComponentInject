package com.twiceyuan.componentinject.impl

import android.content.Context
import android.widget.Toast
import com.twiceyuan.componentinject.submodule.Toaster

class ToasterImpl(private val context: Context) : Toaster {

    override fun short(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun long(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}