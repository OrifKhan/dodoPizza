package com.example.dbfordodo.view.adapter.ListAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.ItemKorzinaBinding
import com.example.dbfordodo.view.diffUtils.OrderDiffUtils
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

class OrderAdapter() : ListAdapter<Pizza, OrderAdapter.OrderViewHolder>(OrderDiffUtils()) {

    var updateAmount : ((Int,Int) -> Unit)? = null
    var deleteProduct : ((Int) ->Unit)? = null
    var list = listOf<Int>()

    inner class OrderViewHolder(itemView: View) : ViewHolder(itemView){
        var binding = ItemKorzinaBinding.bind(itemView)

        fun bind(products: Pizza,pos : Int){
            binding.korzinaItemImage.setImageResource(products.image)
            binding.korzinaItemTitle.text = products.name
            binding.korzinaItemTotal.text = products.price.toString()
            binding.korzinaItemDescription.text = products.about
            binding.korzinaItemAmount.text = list[pos].toString()

            var amount = binding.korzinaItemAmount.text.toString().toInt()

            binding.korzinaCountDelete.setOnClickListener {
                if (amount > 1) {
                    amount--
                    binding.korzinaItemAmount.text = amount.toString()
                    updateAmount?.invoke(products.id,amount)
                } else {
                    deleteProduct?.invoke(products.id)
                }
            }
            binding.korzinaCountAdd.setOnClickListener {
                amount++
                binding.korzinaItemAmount.text = amount.toString()
                updateAmount?.invoke(products.id,amount)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_korzina,parent,false))
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(getItem(position),position)
    }
}