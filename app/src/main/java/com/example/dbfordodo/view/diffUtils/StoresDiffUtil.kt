package com.example.dbfordodo.view.diffUtils

import androidx.recyclerview.widget.DiffUtil
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.StoryData


class StoresDiffUtil: DiffUtil.ItemCallback<StoryData>() {
    override fun areItemsTheSame(oldItem: StoryData, newItem: StoryData)=oldItem==newItem

    override fun areContentsTheSame(oldItem: StoryData, newItem: StoryData)=oldItem.idItem==newItem.idItem
}



