package com.example.blackcoffers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.blackcoffers.databinding.ActivityTab2Binding
import com.google.android.material.tabs.TabLayout

class TabActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTab2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding=ActivityTab2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTabLayout()
        setUpViewPager()
    }

    private fun setUpViewPager() {
        binding.viewPager.apply {
            adapter=viewPagerAdapter(supportFragmentManager,binding.tabLayout.tabCount)
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        }
    }

    private fun setUpTabLayout() {
        binding.tabLayout.apply {
            addTab(this.newTab().setIcon(getDrawable(R.drawable.ic_people)))
            addTab(this.newTab().setIcon(getDrawable(R.drawable.ic_work)))
            addTab(this.newTab().setIcon(getDrawable(R.drawable.ic_office)))

            addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.position?.let {
                        binding.viewPager.currentItem=it
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })

        }
    }
}