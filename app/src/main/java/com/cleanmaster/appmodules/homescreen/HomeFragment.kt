package com.cleanmaster.appmodules.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cleanmaster.R

class HomeFragment : Fragment() {
    lateinit var rvHome: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View?) {
        rvHome = view!!.findViewById(R.id.rvHome)
        rvHome.setLayoutManager(GridLayoutManager(activity, 3))
        rvHome.setHasFixedSize(true);
        setHomeAdapter()
    }

    fun setHomeAdapter() {
        val adapterHome = activity?.let { HomeAdapter(it) }
        rvHome.adapter = adapterHome
    }

}