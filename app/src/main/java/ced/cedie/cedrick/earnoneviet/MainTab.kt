package ced.cedie.cedrick.earnoneviet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import ced.cedie.cedrick.earnoneviet.dataAdapter.MainTabAdapter
import ced.cedie.cedrick.earnoneviet.databinding.MaintabBinding
import com.google.android.material.tabs.TabLayout

class MainTab : AppCompatActivity(), TabLayout.OnTabSelectedListener {

    private lateinit var main : MaintabBinding
    private var counter = 0
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = MaintabBinding.inflate(layoutInflater)
        val mV = main.root
        setContentView(mV)
        tabLayout = main.tab
        viewPager = main.content
        iniTab()
    }

    private fun iniTab() {
        val pagerAdapter: PagerAdapter = MainTabAdapter(supportFragmentManager)
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {}
    override fun onTabUnselected(tab: TabLayout.Tab?) {}
    override fun onTabReselected(tab: TabLayout.Tab?) {}

    override fun onBackPressed() {
        if (counter == 0) {
            counter = 1
            Toast.makeText(this, "Nhấn lại để thoát khỏi ứng dụng!", Toast.LENGTH_LONG).show()
        } else {
            super.finishAffinity()
        }
    }

}