package com.twiceyuan.android.component.inject.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.twiceyuan.android.component.inject.setupFragmentProvider
import org.koin.android.scope.bindScope
import org.koin.android.scope.lifecycleScope
import org.koin.core.scope.Scope

abstract class KoinFragment : Fragment() {

    open val scope: Scope by lazy { lifecycleScope }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        setupFragmentProvider(scope)
        return view
    }
}