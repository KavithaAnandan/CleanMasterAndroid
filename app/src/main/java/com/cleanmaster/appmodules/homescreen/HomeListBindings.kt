package com.cleanmaster.appmodules.homescreen

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cleanmaster.model.apimodel.home.HomeResponse

class HomeListBindings {
    @BindingAdapter("app:homeList")
    fun setHomeList(rvHome: RecyclerView, items: List<HomeResponse>) {
        var homeAdapter: HomeAdapter = rvHome.adapter as HomeAdapter
        homeAdapter?.refresh(items)
    }
}