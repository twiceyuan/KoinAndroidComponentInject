package com.twiceyuan.componentinject.submodule

import org.koin.core.KoinComponent
import org.koin.core.inject

class EncodeViewModel(private val showDialog: ShowDialog) : KoinComponent {

    private val toaster: Toaster by inject()
    private val base64Encoder: Base64Encoder by inject()

    fun showBase64InDialog(originText: String?) {

        if (originText == null || originText.isEmpty()) {
            toaster.short("Please input the text")
            return
        }

        val encodedString = base64Encoder.encode(originText)
        showDialog.showDialog("Text: $originText\nBase64: $encodedString")
    }
}