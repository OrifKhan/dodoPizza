package com.example.dbfordodo.dodoViewMadel.repository

import com.example.dbfordodo.db.data.Constants
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import islom.din.dodo_ilmhona_proskills.khq.dbMain.Order

class GetOrder {
    fun getList(): List<Order> {


        val list = mutableListOf<Order>()
        list.add(Order(0,Constants.USER_ID))
        return list

    }
}