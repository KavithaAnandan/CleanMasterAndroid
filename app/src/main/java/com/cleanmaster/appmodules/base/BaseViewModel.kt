package com.cleanmaster.appmodules.base

import androidx.lifecycle.ViewModel
import com.cleanmaster.appmodules.homescreen.HomeViewModel
import com.cleanmaster.di.component.ViewModelInjector
import com.cleanmaster.di.module.NetworkModule

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is HomeViewModel -> injector.inject(this)
        }
    }
}
