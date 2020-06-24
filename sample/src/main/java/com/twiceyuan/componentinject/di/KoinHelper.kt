package com.twiceyuan.componentinject.di

import android.content.Context
import com.twiceyuan.android.component.inject.currentActivity
import com.twiceyuan.componentinject.ModuleOne
import com.twiceyuan.componentinject.ModuleTwo
import com.twiceyuan.componentinject.impl.*
import com.twiceyuan.componentinject.submodule.Base64Encoder
import com.twiceyuan.componentinject.submodule.EncodeViewModel
import com.twiceyuan.componentinject.submodule.ShowDialog
import com.twiceyuan.componentinject.submodule.Toaster
import com.twiceyuan.componentinject.ui.LifecycleScopeActivity
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.bind
import org.koin.dsl.module

// Init configuration
fun Context.initKoin() {
    startKoin {
        androidLogger(level = Level.DEBUG)
        androidContext(this@initKoin)
        modules(base64Module, cycleModule)
    }
}

private val cycleModule = module {
    single { ModuleOneImpl() } bind ModuleOne::class
    single { ModuleTwoImpl() } bind ModuleTwo::class
}

private val base64Module = module {
    // Inject singleton
    single { Base64EncoderImpl() } bind Base64Encoder::class
    single { ToasterImpl(androidContext()) }  bind Toaster::class

    // Custom scope inject
    scope(Scopes.SCOPE_BASE64_MODULE) {
        scoped { ShowDialogImpl(currentActivity()) } bind ShowDialog::class
        scoped { EncodeViewModel(get()) } bind EncodeViewModel::class
    }

    // Lifecycle scope inject
    scope<LifecycleScopeActivity> {
        scoped { ShowDialogImpl(currentActivity()) } bind ShowDialog::class
        scoped { EncodeViewModel(get()) } bind EncodeViewModel::class
    }
}