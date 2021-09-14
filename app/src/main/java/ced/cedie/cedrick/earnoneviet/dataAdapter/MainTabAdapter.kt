package ced.cedie.cedrick.earnoneviet.dataAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import ced.cedie.cedrick.earnoneviet.fragmentsTab.AdvantageFragment
import ced.cedie.cedrick.earnoneviet.fragmentsTab.DisadvantageFragment
import ced.cedie.cedrick.earnoneviet.fragmentsTab.HomeFragment

class MainTabAdapter (fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager)  {

    private val fragments = arrayListOf("  TRANGCHỦ","LỢITHẾ","BẤTLỢI  ")
    private lateinit var tab1: HomeFragment
    private lateinit var tab2: AdvantageFragment
    private lateinit var tab3: DisadvantageFragment

    override fun getPageTitle(position: Int): CharSequence {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> {
                return HomeFragment().also { tab1 = it }
            }
            1 -> {
                return AdvantageFragment().also { tab2 = it }
            }
            2 -> {
                return DisadvantageFragment().also { tab3 = it }
            }
            else -> getItem(position)
        } } }