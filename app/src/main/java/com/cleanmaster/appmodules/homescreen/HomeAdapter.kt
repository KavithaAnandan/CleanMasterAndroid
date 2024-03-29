package com.cleanmaster.appmodules.homescreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cleanmaster.R
import com.cleanmaster.model.apimodel.home.HomeResponse
import kotlinx.android.synthetic.main.adapter_home.view.*

class HomeAdapter(var context: Context) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    var arrListHome: List<HomeResponse> = ArrayList()

    fun refresh(listHome: List<HomeResponse>) {
        if (arrListHome.isNotEmpty()) {
            try {
                this.arrListHome = listHome
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getItemCount(): Int {
        return arrListHome.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_home, parent, false)


        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.tvServiceName.isSelected = true
        } catch (e: Exception) {

        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvServiceName: TextView = view.tv_Cleaning

    }

}