package com.example.dbfordodo.view.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dbfordodo.fragments.ShowFragment
import islom.din.dodo_ilmhona_proskills.shodmon.bekhruz.StoryItemFragment
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.StoryData

class VpAdapter(lists: List<StoryData>, fragmentActivity: FragmentActivity,pos: Int) : FragmentStateAdapter(fragmentActivity) {
    private val list: List<Fragment>
    init {
        list = mutableListOf()

        for (i in lists) {
            pos + 1
            list.add(StoryItemFragment.newInstance(i, pos))


        }
    }

    override fun getItemCount(): Int =list.size

    override fun createFragment(position: Int): Fragment {

        return list[position]
    }
}