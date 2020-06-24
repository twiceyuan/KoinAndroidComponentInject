package com.twiceyuan.componentinject.impl

import android.util.Log
import com.twiceyuan.componentinject.ModuleOne
import com.twiceyuan.componentinject.ModuleTwo
import org.koin.core.KoinComponent
import org.koin.core.inject

class ModuleOneImpl : ModuleOne, KoinComponent {

    private val moduleTwo: ModuleTwo by inject()

    companion object {
        const val TAG = "ModuleOneImpl"
    }

    override fun callModuleTwoAction() {
        moduleTwo.callModuleOneBaseAction()
    }

    override fun baseAction() {
        Log.i(TAG, "Base Action Success!!!!!")
    }
}
