package com.cleanmaster.appmodules.homescreen

import android.os.Bundle
import com.cleanmaster.R
import com.cleanmaster.appmodules.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.romainpiel.shimmer.Shimmer
import com.romainpiel.shimmer.ShimmerTextView

class HomeScreen : BaseActivity() {
    lateinit var tv_watcanwe: ShimmerTextView
    lateinit var shimmer: Shimmer
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
        if (savedInstanceState == null) {
            val fragment = HomeFragment()
            supportFragmentManager.beginTransaction().replace(R.id.containerHome ,
                fragment, fragment.javaClass.getSimpleName())
                .commit()
        }

    }

    private fun initViews() {
        tv_watcanwe = findViewById(R.id.tv_watcanwe)
        bottomNavigationView = findViewById(R.id.bnv_tabs)

        shimmer = Shimmer()
        shimmer.start(tv_watcanwe)
        shimmer.duration = 3000

        setupBottomNavigationView()

    }

    private fun setupBottomNavigationView() {

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    showToast("Home")
                    val fragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.containerHome, fragment,
                        fragment.javaClass.getSimpleName()
                    ).commit()

                    true
                }
                R.id.menu_search -> {
                    showToast("Search")
                    true
                }
                R.id.menu_history -> {
                    showToast("History")
                    true
                }
                R.id.menu_settings -> {
                    showToast("Settings")
                    true
                }
                else -> false
            }

        }
    }


}