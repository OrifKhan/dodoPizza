package com.example.dbfordodo.dodoViewMadel.madelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dbfordodo.dodoViewMadel.viewModel.RoomViewModel
import com.example.dbfordodo.madel.daoInterface.IngredientsDao
import com.example.dbfordodo.madel.daoInterface.IngredientsProductsConnectionDao
import com.example.dbfordodo.madel.daoInterface.OrderDao
import com.example.dbfordodo.madel.daoInterface.ProductsDao

class RoomViewModelFactory(private val ingredientsDao: IngredientsDao,
                           private val ingredientsProductsConnectionDao: IngredientsProductsConnectionDao,
                           private val productsDao: ProductsDao,
                           private val orderDao: OrderDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RoomViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return RoomViewModel(ingredientsDao, ingredientsProductsConnectionDao,productsDao,orderDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}

