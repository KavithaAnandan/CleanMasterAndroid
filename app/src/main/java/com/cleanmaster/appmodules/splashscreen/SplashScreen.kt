package com.cleanmaster.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.cleanmaster.R
import com.cleanmaster.appmodules.welcomescreen.SigninScreen
import com.cleanmaster.appmodules.welcomescreen.WelcomeScreen

class SplashScreen : AppCompatActivity() {
    lateinit var ivLogo : ImageView
    var SPLASH_DISPLAY_LENGTH : Int = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ivLogo = findViewById(R.id.iv_appLogo);

        val myFadeInAnimation = AnimationUtils.loadAnimation(this,R.anim.tween)
        ivLogo.startAnimation(myFadeInAnimation);
        goNext()
    }
     fun goNext(){
         Handler().postDelayed({
             /* Create an Intent that will start the Login-Activity. */
             val mainIntent = Intent(this, WelcomeScreen::class.java)
             startActivity(mainIntent)
             finish()
         }, SPLASH_DISPLAY_LENGTH.toLong())

     }
/*
    override fun onStart() {
        super.onStart()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }*/

}