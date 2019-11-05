package com.cleanmaster.appmodules.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cleanmaster.R
import com.cleanmaster.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var rvHome: RecyclerView
    lateinit var homeViewModel: HomeViewModel
    lateinit var fragmentHomeBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        fragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        initViews(view)
    }

    private fun initViews(view: View?) {
        rvHome = view!!.findViewById(R.id.rvHome)

        setHomeAdapter()


    }

    fun setHomeAdapter() {
        rvHome.setLayoutManager(GridLayoutManager(activity, 3))
        rvHome.setHasFixedSize(true)

        fragmentHomeBinding.model = homeViewModel
        val adapterHome = activity?.let { HomeAdapter(it) }
        rvHome.adapter = adapterHome
    }

}