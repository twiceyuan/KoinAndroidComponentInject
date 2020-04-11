package com.twiceyuan.componentinject.impl

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import com.twiceyuan.componentinject.submodule.ShowDialog
import org.koin.core.KoinComponent

class ShowDialogImpl(private val activity: Activity?) : ShowDialog, KoinComponent {

    override fun showDialog(message: String) {
        activity ?: return
        AlertDialog.Builder(activity)
            .setTitle("Dialog: ${this.hashCode()}")
            .setMessage(message)
            .show()
    }
}