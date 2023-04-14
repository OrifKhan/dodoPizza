package com.example.dbfordodo.dodoViewMadel.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.dbfordodo.madel.data.Combo
import com.example.dbfordodo.dodoViewMadel.repository.*
import com.example.dbfordodo.dodoViewMadel.retrafitRepository.MainApi
import com.example.dbfordodo.dodoViewMadel.retrafitRepository.Retrofit
import com.example.dbfordodo.madel.daoInterface.PizzaDao
import islom.din.dodo_ilmhona_proskills.db.data.Category
import islom.din.dodo_ilmhona_proskills.db.data.Ingridients
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import islom.din.dodo_ilmhona_proskills.db.data.Vkus
import com.example.dbfordodo.madel.data.OrderConnectionServer
import com.example.dbfordodo.madel.daoInterface.OrderDao
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.StoryData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DodoViewMadel(
    val pizzaDao: PizzaDao,
    val orderDao: OrderDao,
) : ViewModel() {

    private val mainApi: MainApi =Retrofit().retrofit.create(MainApi::class.java)

    fun insertViewMadel() {
        viewModelScope.launch(Dispatchers.IO) {

          /*  for(it in mainApi.getStores().body()!!){
                pizzaDao.insertStores(it)
            }
            for(it in mainApi.getPizza().body()!!){
                pizzaDao.insertPizza(it)
            }
            for(it in mainApi.getCategory().body()!!){
                pizzaDao.insertCotegory(it)
            }
            for(it in mainApi.getIngredient().body()!!){
                pizzaDao.insertIngredient(it)
            }
            for(it in mainApi.getCombo().body()!!){
                pizzaDao.insertCombo(it)
            }
            for(it in mainApi.getOrder().body()!!){
                orderDao.newOrder(it)
            }
            for(it in mainApi.getVkus().body()!!){
                pizzaDao.insertVkus(it)
            }*/
            Log.d("hello", "errrro")
            mainApi.getOrder().body()?.forEach {
                orderDao.newOrder(it)
            }
            mainApi.getStores().body()?.forEach {
                pizzaDao.insertStores(it)
            }
            mainApi.getPizza().body()?.forEach() {
                pizzaDao.insertPizza(it)
            }
            mainApi.getCategory().body()?.forEach() {
                pizzaDao.insertCotegory(it)
            }

            mainApi.getIngredient().body()?.forEach() {
                pizzaDao.insertIngredient(it)
            }
            mainApi.getCombo().body()?.forEach() {
                pizzaDao.insertCombo(it)
            }
            GetHalfList().getList().forEach {
                pizzaDao.insertHalfPizza(it)
            }
            mainApi.getVkus().body()?.forEach {
                pizzaDao.insertVkus(it)
            }



        }

    }
    fun updateComboPizza(id: Int,id_pizza: Int) {
        viewModelScope.launch {

        pizzaDao.updateComboPizza(id,id_pizza)
        }

    }

    fun getHistory(): LiveData<List<OrderConnectionServer>> {
        return orderDao.getHistoryOrders()
    }
    fun getPizza(): LiveData<List<Pizza>> {
        return pizzaDao.getAllPizza()
    }
    fun getPizzaId(id:Int): LiveData<List<Pizza>> {
        return pizzaDao.getPizzaId(id).asLiveData()
    }

    fun getVkus(size: Int): LiveData<List<Vkus>> {
        return pizzaDao.getAllVkus(size)
    }

    fun getStores(id: Int): LiveData<List<StoryData>> {
        return pizzaDao.getAllStores(id)
    }

    fun getMaineStores(main:Int): LiveData<List<StoryData>> {
        return pizzaDao.getMaineStores(main)
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