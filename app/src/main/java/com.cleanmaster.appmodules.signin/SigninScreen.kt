package com.cleanmaster.appmodules.welcomescreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.cleanmaster.R
import com.cleanmaster.appmodules.base.BaseActivity
import com.cleanmaster.appmodules.homescreen.HomeScreen
import com.cleanmaster.appmodules.signup.SignupScreen
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.ncrcinema.movietime.marcus.commonview.UtilDialog

class SigninScreen : BaseActivity() {
    lateinit var inputEmail: TextInputLayout
    lateinit var inputPass: TextInputLayout
    lateinit var editEmail: TextInputEditText
    lateinit var editPass: TextInputEditText
    lateinit var btnSignin: MaterialButton
    lateinit var tvNotYou: TextView
    lateinit var tvHavingTrouble: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        initViews()
    }

    private fun initViews() {
        inputEmail = findViewById(R.id.inputEmail)
        inputPass = findViewById(R.id.inputPass)
        editEmail = findViewById(R.id.editEmail)
        editPass = findViewById(R.id.editPass)
        btnSignin = findViewById(R.id.btnSignin)
        tvNotYou = findViewById(R.id.tvNotYou)
        tvHavingTrouble = findViewById(R.id.tvHavingTrouble)


        tvNotYou.setOnClickListener {
            var intent = Intent(this, SignupScreen::class.java)
            startActivity(intent)
        }
        btnSignin.setOnClickListener {
            UtilDialog.showProgressDialog(this)

            Handler().postDelayed({
                UtilDialog.hideProgress()
                var intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)

            }, 3000)

        }

    }


}