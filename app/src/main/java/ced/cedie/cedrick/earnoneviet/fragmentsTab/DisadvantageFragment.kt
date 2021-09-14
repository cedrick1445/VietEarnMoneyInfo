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
import ced.cedie.cedrick.earnoneviet.databinding.DisadvantageBinding

class DisadvantageFragment : Fragment() {
    private lateinit var dAdv : DisadvantageBinding
    private lateinit var dAdvData : DViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dAdv = DisadvantageBinding.inflate(layoutInflater)
        val rootA : View = dAdv.root
        dAdvData = ViewModelProvider(this).get(DViewModel::class.java)
        dAdvData.homeData()
        disadvantage()
        return rootA
    }
    private fun disadvantage() {
        dAdvData.data.observe(viewLifecycleOwner,{
            val hData = DataAdapter()
            hData.setData(it)
            dAdv.recycleDAdv.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = hData
            } }) }
}