package com.example.dbfordodo.view.adapter.ListAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.StoriesItemBinding
import com.example.dbfordodo.view.diffUtils.StoresDiffUtil
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.StoryData

class AdepterSores:ListAdapter<StoryData, AdepterSores.ViewHolder>(StoresDiffUtil()) {
    var itemOnClick: ((Int) -> Unit)? =null
    inner class ViewHolder(itemView: View):androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView){
        val binding= StoriesItemBinding.bind(itemView)

        fun bind(stores:StoryData){
            binding.storyPhoto.setImageResource(stores.image)
        }
        init {
            binding.root.setOnClickListener {
                itemOnClick?.invoke(adapterPosition)
            }
    }}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.stories_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(getItem(position))
    }
}
