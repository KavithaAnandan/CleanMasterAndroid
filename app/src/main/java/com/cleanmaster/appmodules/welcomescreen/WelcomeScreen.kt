package com.cleanmaster.appmodules.welcomescreen

import android.os.Bundle
import com.cleanmaster.R
import com.cleanmaster.appmodules.common.BaseActivity

class WelcomeScreen : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

}