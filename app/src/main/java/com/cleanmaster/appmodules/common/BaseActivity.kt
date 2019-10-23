package com.cleanmaster.appmodules.common

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout

abstract class BaseActivity : AppCompatActivity() {
    lateinit var ll_body: LinearLayout
    lateinit var appbar_layout: AppBarLayout
    lateinit var inflater: LayoutInflater
    var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*  setContentView(R.layout.activity_base)

          ll_body = findViewById(R.id.ll_body)
          appbar_layout = findViewById(R.id.appbar_layout)
          inflater = layoutInflater
          toolbar = findViewById(R.id.toolbar)

          ///setting up simple_toolbar as Action bar
          setSupportActionBar(toolbar)
          intialiseLayout()*/

    }

    fun showToast(message: String) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show()
    }

//    protected abstract fun intialiseLayout()

}