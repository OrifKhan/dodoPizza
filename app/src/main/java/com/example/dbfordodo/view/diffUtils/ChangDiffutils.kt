package com.example.dbfordodo.view.diffUtils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

class ChangDiffutils : DiffUtil.ItemCallback<Pizza>() {
    override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza):Boolean =  oldItem.id == newItem.id
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean =  oldItem == newItem
}