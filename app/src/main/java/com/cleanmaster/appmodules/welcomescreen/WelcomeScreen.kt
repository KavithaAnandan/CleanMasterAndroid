package com.cleanmaster.appmodules.welcomescreen

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cleanmaster.R
import com.cleanmaster.appmodules.signup.SignupScreen

class WelcomeScreen : AppCompatActivity() {
    var btnSignin: TextView? = null
    var btnSignup: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initViews()
    }

    private fun initViews() {
        btnSignin = findViewById(R.id.btnSignin)
        btnSignup = findViewById(R.id.btnSignup)

        btnSignin?.setOnClickListener {
            val intent = Intent(this, SigninScreen::class.java)
            startActivity(intent)
        }
        btnSignup?.setOnClickListener {
            val intent = Intent(this, SignupScreen::class.java)
            startActivity(intent)
        }
    }

}