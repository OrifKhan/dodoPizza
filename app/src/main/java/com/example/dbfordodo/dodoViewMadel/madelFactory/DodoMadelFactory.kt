package com.example.dbfordodo.dodoViewMadel.madelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dbfordodo.dodoViewMadel.viewModel.DodoViewMadel
import com.example.dbfordodo.madel.daoInterface.PizzaDao
import com.example.dbfordodo.madel.daoInterface.OrderDao

class DodoMadelFactory(val pizzaDao: PizzaDao,
                       val orderDao: OrderDao
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DodoViewMadel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DodoViewMadel(pizzaDao, orderDao) as T
        }
         throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
