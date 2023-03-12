package com.example.dbfordodo.dodoViewMadel.repository

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
import islom.din.dodo_ilmhona_proskills.db.dao.PizzaDao

class DodoMadelFactory(private val app: Application,private val pizzaDao: PizzaDao,
): ViewModelProvider.AndroidViewModelFactory(app) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DodoViewMadel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return DodoViewMadel(app,pizzaDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
