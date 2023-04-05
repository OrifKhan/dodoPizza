package com.example.dbfordodo.view.adapter.ListAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.ItemRecyclerSousViewBinding
import com.example.dbfordodo.view.diffUtils.MyDiffUtil
import islom.din.dodo_ilmhona_proskills.db.data.Vkus


class ListSousAdapter() : ListAdapter<Vkus, ListSousAdapter.SousViewHolder>(MyDiffUtil()) {
    var onClick: ((Int) -> Unit) = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SousViewHolder {
        return SousViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler_sous_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SousViewHolder, position: Int) {
        holder.run {
            bindImage(getItem(position))
            bindText(getItem(position))
            bindSena(getItem(position))
        }
    }

    inner class SousViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemRecyclerSousViewBinding.bind(itemView)
        fun bindImage(vkus: Vkus) {
            binding.imageSous.setImageResource(vkus.image)

            binding.root.setOnClickListener() {
                onClick.invoke(adapterPosition)
                vkus.select = 1
                showChecked(vkus)

                showHide(binding.selectImage)
                showHide(binding.seconClock)

            }
            binding.seconClock.setOnClickListener() {
                vkus.select = 0
                showChecked(vkus)
                showHide(binding.seconClock)
                showHide(binding.selectImage)
            }

        }


        fun bindText(vkus: Vkus) {
            binding.sousName.text = vkus.name
        }

        fun bindSena(vkus: Vkus) {

                    binding.sena.text = vkus.priceSmall.toString()



        }

        fun showHide(view: View) {
            view.visibility = if (view.visibility == View.VISIBLE) {
                View.INVISIBLE
            } else {
                View.VISIBLE
            }
        }

        fun showChecked(vkus: Vkus) {
            if (vkus.select == 1) {

                binding.begItem.setBackgroundResource(R.drawable.stoke_select.toInt())
            } else {
                binding.begItem.setBackgroundResource(R.drawable.stoke_not_select)
            }

        }


    }
}





