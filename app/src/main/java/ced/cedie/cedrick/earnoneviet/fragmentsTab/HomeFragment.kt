package ced.cedie.cedrick.earnoneviet.fragmentsTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ced.cedie.cedrick.earnoneviet.dataAdapter.PDataAdapt
import ced.cedie.cedrick.earnoneviet.dataViewModel.DViewModel
import ced.cedie.cedrick.earnoneviet.databinding.HomeBinding

class HomeFragment : Fragment() {

    private lateinit var home : HomeBinding
    private lateinit var hData : DViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        home = HomeBinding.inflate(layoutInflater)
        val rootH : View = home.root
        hData = ViewModelProvider(this).get(DViewModel::class.java)
        hData.homeData()
        viewHome()
        return rootH
    }

    private fun viewHome() {
        hData.data.observe(viewLifecycleOwner,{
            val hData = context?.let { pic -> PDataAdapt(pic) }
            hData?.setPH(it)
            home.recycleHome.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = hData
            } }) }
    }

