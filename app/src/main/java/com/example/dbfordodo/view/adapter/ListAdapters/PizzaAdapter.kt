package com.example.dbfordodo.view.adapter.ListAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dbfordodo.R
import com.example.dbfordodo.databinding.PizzaItemBinding
import com.example.dbfordodo.databinding.PizzaItemMainBinding
import com.example.dbfordodo.madel.data.Constants
import islom.din.dodo_ilmhona_proskills.QA.diffUtils.PizzaDiffUtls
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

class PizzaAdapter() : ListAdapter<Pizza, ViewHolder>(PizzaDiffUtls()) {

    var onClick: ((Int, Pizza) -> Unit)? = null
    var order: ((Pizza) -> Unit)? = null

    inner class PizzaMainViewHolder(itemView: View) : ViewHolder(itemView) {
        private var binding = PizzaItemMainBinding.bind(itemView)

        fun bind(pizzaData: Pizza) {
            binding.pizzaImage.setImageResource(pizzaData.image)
            binding.pizzaName.text = pizzaData.name
            binding.pizzaAbout.text = pizzaData.about
            binding.pizzaPrice.text = pizzaData.formatPriceSmall()

            binding.pizzaPrice.setOnClickListener {
                order?.invoke(pizzaData)
            }
            if (pizzaData.category == Constants.COMBO) {
                binding.root.setOnClickListener {
                    onClick?.invoke(pizzaData.id, pizzaData)
                }
            } else {
                binding.root.setOnClickListener {
                    onClick?.invoke(adapterPosition, pizzaData)
                }

            }
        }
    }

    inner class PizzaViewHolder(itemView: View) : ViewHolder(itemView) {
        private var binding = PizzaItemBinding.bind(itemView)

        fun bind(pizzaData: Pizza) {
            binding.pizzaImage.setImageResource(pizzaData.image)
            binding.pizzaName.text = pizzaData.name
            binding.pizzaAbout.text = pizzaData.about
            binding.pizzaPrice.text = pizzaData.formatPriceSmall()
            binding.pizzaPrice.setOnClickListener {
                order?.invoke(pizzaData)
            }
            if (pizzaData.category == Constants.COMBO) {
                binding.root.setOnClickListener {
                    onClick?.invoke(pizzaData.id, pizzaData)
                }
            } else {
                binding.root.setOnClickListener {
                    onClick?.invoke(adapterPosition, pizzaData)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).main==1) {     PIZZAMAIN
        }

            else {
            PIZZA
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == PIZZA) PizzaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.pizza_item, parent, false)
        )
        else PizzaMainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.pizza_item_main, parent, false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is PizzaMainViewHolder)
            holder.bind(getItem(position))
        else if (holder is PizzaViewHolder)
            holder.bind(getItem(position))
    }

    companion object {
        const val PIZZAMAIN = 0
        const val PIZZA = 1
    }
}