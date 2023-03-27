package com.example.dbfordodo.dodoViewMadel.repository

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import islom.din.dodo_ilmhona_proskills.db.dao.PizzaDao
import islom.din.dodo_ilmhona_proskills.khq.dbMain.OrderDao

class DodoMadelFactory(val pizzaDao: PizzaDao,
                       val orderDao: OrderDao
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DodoViewMadel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return DodoViewMadel(pizzaDao, orderDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
