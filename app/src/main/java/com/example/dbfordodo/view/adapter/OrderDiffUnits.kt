package islom.din.dodo_ilmhona_proskills.view.adapter

import androidx.recyclerview.widget.DiffUtil
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

class OrderDiffUnits: DiffUtil.ItemCallback<Pizza>() {
    override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza) = oldItem == newItem
}