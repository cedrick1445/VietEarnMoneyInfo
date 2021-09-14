package ced.cedie.cedrick.earnoneviet.fragmentsTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ced.cedie.cedrick.earnoneviet.dataAdapter.DataAdapter
import ced.cedie.cedrick.earnoneviet.dataViewModel.DViewModel
import ced.cedie.cedrick.earnoneviet.databinding.AdvantageBinding


class AdvantageFragment : Fragment() {
    private lateinit var adv : AdvantageBinding
    private lateinit var advData : DViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        adv = AdvantageBinding.inflate(layoutInflater)
        val rootA : View = adv.root
        advData = ViewModelProvider(this).get(DViewModel::class.java)
        advData.homeData()
        advantage()
        return rootA
    }

    private fun advantage() {
        advData.data.observe(viewLifecycleOwner,{
            val hData = DataAdapter()
            hData.setData(it)
            adv.recycleAdv.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = hData
            } }) }


}