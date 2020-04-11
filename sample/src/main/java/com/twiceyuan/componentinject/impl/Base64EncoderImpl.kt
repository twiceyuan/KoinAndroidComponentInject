package com.twiceyuan.componentinject.impl

import android.util.Base64
import com.twiceyuan.componentinject.submodule.Base64Encoder

class Base64EncoderImpl: Base64Encoder {
    override fun encode(originText: String): String {
        return Base64.encodeToString(originText.toByteArray(), Base64.NO_WRAP)
    }
}
