package com.example.dbfordodo.view.ViewPager

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.PagerPizzaBinding
import islom.din.dodo_ilmhona_proskills.db.data.Pizza


class PagerPizzaAdpater : ListAdapter<Pizza, PagerPizzaAdpater.PagerViewHolder>(
    object : DiffUtil.ItemCallback<Pizza>() {
        override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza): Boolean =
            oldItem.id == newItem.id

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean =
            oldItem == newItem
    }
) {
    var list= mutableListOf<Pizza>()
var pos:Int=0
    var onSelectItem: ((Pizza) -> (Unit))? = null

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = PagerPizzaBinding.bind(itemView)
        fun bind(changeData: Pizza) {
            binding.description.text = changeData.about
            binding.image.setImageResource(changeData.image)
            binding.name.text = changeData.name



            binding.choosePizza.setOnClickListener {
                onSelectItem?.invoke(changeData)
                binding.choosePizza.setBackgroundResource(R.drawable.back_selcted)
                list[pos]=changeData
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pager_pizza,parent,false))
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

