package com.cleanmaster.appmodules.signup

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.cleanmaster.R
import com.cleanmaster.appmodules.common.BaseActivity
import com.cleanmaster.appmodules.homescreen.HomeScreen
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupScreen : BaseActivity() {
    lateinit var inputEmail: TextInputLayout
    lateinit var inputPass: TextInputLayout
    lateinit var inputConPass: TextInputLayout
    lateinit var editEmail: TextInputEditText
    lateinit var editPass: TextInputEditText
    lateinit var editConPass: TextInputEditText
    lateinit var btnSignup: MaterialButton
    lateinit var tvAlready: TextView
    lateinit var tvDOB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        initViews()
    }

    private fun initViews() {
        inputEmail = findViewById(R.id.inputEmail)
        inputPass = findViewById(R.id.inputPass)
        inputConPass = findViewById(R.id.inputConPass)
        editEmail = findViewById(R.id.editName)
        editPass = findViewById(R.id.editPass)
        editConPass = findViewById(R.id.editConPass)
        btnSignup = findViewById(R.id.btnSignup)
        tvAlready = findViewById(R.id.tvAlreadybeen)
        tvDOB = findViewById(R.id.tvDOB)

        btnSignup.setOnClickListener {
            var intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }
    }
}