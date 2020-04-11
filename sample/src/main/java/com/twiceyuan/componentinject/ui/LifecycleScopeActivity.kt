package com.twiceyuan.componentinject.ui

import android.os.Bundle
import com.twiceyuan.android.component.inject.components.KoinActivity
import com.twiceyuan.componentinject.R
import com.twiceyuan.componentinject.start
import com.twiceyuan.componentinject.submodule.EncodeViewModel
import kotlinx.android.synthetic.main.activity_scope_inject.*
import org.koin.android.scope.lifecycleScope

class LifecycleScopeActivity : KoinActivity() {

    // inject by lifecycle scope
    private val encodeViewModel: EncodeViewModel by lifecycleScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope_inject)

        // Show current activity indicator
        tv_current_activity.text = getString(R.string.current_activity, this.toString())

        btn_get_base64.setOnClickListener {
            encodeViewModel.showBase64InDialog(et_to_encode.text.toString())
        }

        btn_new_activity.setOnClickListener {
            // create a new MainActivity instance
            start<LifecycleScopeActivity>()
        }
    }
}
