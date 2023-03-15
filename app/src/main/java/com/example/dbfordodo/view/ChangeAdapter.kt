package com.example.dbfordodo.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.ComboDezignBinding
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

class ChangeAdapter:ListAdapter<Pizza,ChangeAdapter.ChangeViewHolder>(ChangDiffutils()) {
    var onClickItem:((Pizza, Int)->Unit)? = null

    inner class ChangeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ComboDezignBinding.bind(itemView)

        fun bind(pizza: Pizza){
            binding.imageComboDezign.setImageResource(pizza.image)
            binding.nameComboDezign.text = pizza.name
            binding.descriptionComboDezig.text = pizza.name

            binding.root.setOnClickListener {
                onClickItem?.invoke(pizza,adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChangeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.combo_dezign,parent,false)
        return ChangeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChangeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ChangDiffutils :DiffUtil.ItemCallback<Pizza>() {
    override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza):Boolean =  oldItem.id == newItem.id
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean =  oldItem == newItem
}