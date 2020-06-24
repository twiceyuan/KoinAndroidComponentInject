package com.twiceyuan.componentinject.impl

import com.twiceyuan.componentinject.ModuleOne
import com.twiceyuan.componentinject.ModuleTwo
import org.koin.core.KoinComponent
import org.koin.core.inject

class ModuleTwoImpl: ModuleTwo, KoinComponent {

    private val moduleOne: ModuleOne by inject()

    override fun callModuleOneBaseAction() {
        moduleOne.baseAction()
    }
}