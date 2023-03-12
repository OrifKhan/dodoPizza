package com.example.dbfordodo.dodoViewMadel.repository

import com.example.dbfordodo.db.data.Constants
import islom.din.dodo_ilmhona_proskills.db.data.Category

// -------- NOT USED ------------ //
// ------------------------------//


class GetCategoryList {

    //List of categories
    fun getCategory(): List<Category> {
        val list = mutableListOf<Category>()

        list.add(Category(0,Constants.PIZZA))
        list.add(Category(0,Constants.COMBO))
        list.add(Category(0,Constants.ZAKUSKI))
        list.add(Category(0,Constants.DESERTI))
        list.add(Category(0,Constants.NAPITKI))
        list.add(Category(0,Constants.SOUSI))
        list.add(Category(0,Constants.DRUGIE))

        return list
    }
}