package islom.din.dodo_ilmhona_proskills.view.ViewPager

import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dbfordodo.db.data.Constants
import com.example.dbfordodo.fragments.ShowFragment
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import kotlin.coroutines.coroutineContext

class ViewPagerAdapter(fa: FragmentViewPager, lists: List<Pizza>, pos: Int) :
    FragmentStateAdapter(fa) {
    private val list: List<Fragment>

    init {
        list = mutableListOf()

        for (i in lists) {

            list.add(ShowFragment.newInstance(i, pos))
            pos + 1
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}