package com.example.dbfordodo.dodoViewMadel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dbfordodo.db.data.Constants
import com.example.dbfordodo.dodoViewMadel.repository.GetPizzaList
import islom.din.dodo_ilmhona_proskills.db.dao.PizzaDao
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import kotlin.random.Random

class HomeViewModel(app:Application,pizzaDao: PizzaDao) : AndroidViewModel(app) {

    //Getting category list from repository permanently  for category recycler view in home fragment
//    var categoryList: List<Category> = GetCategoryList().getCategory()

    // Getting pizza list from repository for pizza recycler view in home fragment
    var pizzaList = pizzaDao.getAllPizza()

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