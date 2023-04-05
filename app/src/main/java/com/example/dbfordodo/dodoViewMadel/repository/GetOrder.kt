package com.example.dbfordodo.dodoViewMadel.repository

import com.example.dbfordodo.madel.data.Constants
import com.example.dbfordodo.madel.data.Order

class GetOrder {
    fun getList(): List<Order> {


        val list = mutableListOf<Order>()
        list.add(Order(0,Constants.USER_ID))
        return list

    }
}