package com.example.blackcoffers

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.blackcoffers.databinding.FragmentExploreBinding
import java.text.FieldPosition

class viewPagerAdapter( fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return ExploreFragment()
            }
            1 -> {
                return ExploreFragment2()
            }
            2 -> {
                // val movieFragment = MovieFragment()
                return ExploreFragment3()
            }
            else -> return ExploreFragment()
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }

}