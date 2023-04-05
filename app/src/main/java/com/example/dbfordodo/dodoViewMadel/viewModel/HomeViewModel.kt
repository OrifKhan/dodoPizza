package com.example.dbfordodo.dodoViewMadel.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dbfordodo.madel.data.Constants
import com.example.dbfordodo.madel.daoInterface.PizzaDao
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

class HomeViewModel(pizzaDao: PizzaDao) : ViewModel() {

    var hideBottomNavView = true

    private var _orderType = MutableLiveData(Constants.DOSTAVKA)
    val orderStreet : LiveData<String> get() = _orderType

    fun changeOrderType(type : String){
        _orderType.value = type
    }

    fun interestingList() : List<Pizza> {
        val newList = mutableListOf<Pizza>()
/*
        for (pizza in 0..9) {
            var randomPizza = Random.nextInt(0,pizzaList.value)
            newList.add(pizzaList!![randomPizza])
        }*/

        return newList
    }

    val categoryList =
        arrayListOf(
            Constants.PIZZA,
            Constants.COMBO,
            Constants.ZAKUSKI,
            Constants.DESERTI,
            Constants.NAPITKI,
            Constants.SOUSI,
            Constants.DRUGIE)
}