package com.example.dbfordodo.dodoViewMadel.madelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dbfordodo.dodoViewMadel.viewModel.HomeViewModel
import com.example.dbfordodo.madel.daoInterface.PizzaDao

class HomeViewMadelFactory(private val pizzaDao: PizzaDao):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(pizzaDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}