package com.cellstechlimited.myweb.view.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cellstechlimited.myweb.view.view.fragments.Active
import com.cellstechlimited.myweb.view.view.fragments.Qulified

class FaramingViewpagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Active()
            1 -> Qulified()
            else -> Active()
        }
    }
}