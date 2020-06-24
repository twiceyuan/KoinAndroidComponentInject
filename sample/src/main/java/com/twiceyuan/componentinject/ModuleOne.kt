package com.twiceyuan.componentinject

interface ModuleOne {

    /**
     * 调用 Module Two 的 Action 方法
     */
    fun callModuleTwoAction()

    fun baseAction()
}