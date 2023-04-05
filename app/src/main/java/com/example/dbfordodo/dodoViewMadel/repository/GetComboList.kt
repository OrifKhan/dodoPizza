package com.example.dbfordodo.dodoViewMadel.repository

import com.example.dbfordodo.madel.data.Combo

class GetComboList {
    fun getList(): List<Combo> {


        val list = mutableListOf<Combo>()

        list.add(Combo(0,55,5))
        list.add(Combo(0,55,8))
        list.add(Combo(0,55,11))

        list.add(Combo(0,56,5))
        list.add(Combo(0,56,8))
        list.add(Combo(0,56,11))
        list.add(Combo(0,56,11))
        list.add(Combo(0,56,14))
        list.add(Combo(0,56,17))
        list.add(Combo(0,56,20))
        list.add(Combo(0,56,23))
        list.add(Combo(0,56,27))
        list.add(Combo(0,56,30))

        list.add(Combo(0,57,34))
        list.add(Combo(0,57,44))

        list.add(Combo(0,58,17))
        list.add(Combo(0,58,20))
        list.add(Combo(0,58,23))
        list.add(Combo(0,58,27))
        list.add(Combo(0,58,30))
        list.add(Combo(0,58,33))
        list.add(Combo(0,58,36))

        list.add(Combo(0,59,30))
        list.add(Combo(0,59,33))
        list.add(Combo(0,59,84))

        list.add(Combo(0,60,34))
        list.add(Combo(0,60,71))
        list.add(Combo(0,60,73))

        list.add(Combo(0,61,67))
        list.add(Combo(0,61,67))
        list.add(Combo(0,61,67))
        list.add(Combo(0,61,67))

        list.add(Combo(0,62,27))
        list.add(Combo(0,62,67))
        list.add(Combo(0,62,86))
        list.add(Combo(0,62,94))

        list.add(Combo(0,63,67))
        list.add(Combo(0,63,67))

        list.add(Combo(0,64,86))
        list.add(Combo(0,64,86))

        return list
    }
    }