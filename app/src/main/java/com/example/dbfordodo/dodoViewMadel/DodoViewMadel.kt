package com.example.dbfordodo.dodoViewMadel

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dbfordodo.R
import com.example.dbfordodo.db.dao.dbMain.DodoDataBase
import com.example.dbfordodo.db.data.Combo
import com.example.dbfordodo.dodoViewMadel.repository.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import islom.din.dodo_ilmhona_proskills.db.dao.PizzaDao
import islom.din.dodo_ilmhona_proskills.db.data.Category
import islom.din.dodo_ilmhona_proskills.db.data.Ingridients
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import islom.din.dodo_ilmhona_proskills.db.data.Vkus
import islom.din.dodo_ilmhona_proskills.khq.dbMain.OrderDao
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.StoryData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DodoViewMadel(
    val pizzaDao: PizzaDao,
    val orderDao: OrderDao,
) : ViewModel() {

    fun insertViewMadel() {
        viewModelScope.launch(Dispatchers.IO) {

            Log.d("hello", "errrro")
            GetVkusList().getList().forEach {
                pizzaDao.insertVkus(it)
            }
            GetPizzaList().getList().forEach() {
                pizzaDao.insertPizza(it)
            }
            GetCategoryList().getCategory().forEach() {
                pizzaDao.insertCotegory(it)
            }

            GetIngridientList().getList().forEach() {
                pizzaDao.insertIngredient(it)
            }
            GetComboList().getList().forEach() {
                pizzaDao.insertCombo(it)
            }
            GetHalfList().getList().forEach {
                pizzaDao.insertHalfPizza(it)
            }
            GetStores().getList().forEach {
                pizzaDao.insertStores(it)
            }
           /* GetOrder().getList().forEach {
                orderDao.newOrder(it)
            }*/



        }

    }
    fun updateComboPizza(id: Int,id_pizza: Int) {
        viewModelScope.launch {

        pizzaDao.updateComboPizza(id,id_pizza)
        }

    }

    fun getPizza(): LiveData<List<Pizza>> {
        return pizzaDao.getAllPizza()
    }

    fun getVkus(size: Int): LiveData<List<Vkus>> {
        return pizzaDao.getAllVkus(size)
    }

    fun getStores(id: Int): LiveData<List<StoryData>> {
        return pizzaDao.getAllStores(id)
    }

    fun getMaineStores(maine: Boolean): LiveData<List<StoryData>> {
        return pizzaDao.getMaineStores(maine)
    }

    fun getIngridient(id: Int): LiveData<List<Ingridients>> {
        return pizzaDao.getIngredient(id)
    }

    fun getAllCotegory(): LiveData<List<Category>> {
        return pizzaDao.getCotegory()
    }

    fun getAllSizeNormal(size: Int): LiveData<List<Pizza>> {
        return pizzaDao.getAllSizeNormal(size)
    }

    fun getChoicePizza(things: Int, size: Int): LiveData<List<Pizza>> {
        return pizzaDao.getThreePizza(things, size)
    }

    fun getCategory(category: String): LiveData<List<Pizza>> {
        return pizzaDao.getCatedory(category)
    }

    fun getCategoryWithSize(category: String, size: Int): LiveData<List<Pizza>> {
        return pizzaDao.getCatedoryWithSize(category, size)
    }

    fun getCombo(id: Int): LiveData<List<Pizza>> {
        return pizzaDao.getAllCombo(id)
    }

    fun getComboPizza(id: Int): LiveData<List<Combo>> {
        return pizzaDao.getComboPizza(id)
    }



    fun getPizzaNameWithSize(name: String, size: Int): LiveData<List<Pizza>> {
        return pizzaDao.getPizzaNameWithSize(name, size)
    }

    fun getPizzaName(name: String): LiveData<List<Pizza>> {
        return pizzaDao.getPizzaName(name)
    }


}