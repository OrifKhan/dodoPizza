package com.example.dbfordodo.dodoViewMadel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.dbfordodo.db.dao.dbMain.DodoDataBase
import com.example.dbfordodo.db.data.Combo
import com.example.dbfordodo.dodoViewMadel.repository.*
import islom.din.dodo_ilmhona_proskills.db.dao.PizzaDao
import islom.din.dodo_ilmhona_proskills.db.data.Category
import islom.din.dodo_ilmhona_proskills.db.data.Ingridients
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import islom.din.dodo_ilmhona_proskills.db.data.Vkus
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.StoryData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DodoViewMadel(app: Application, pizzaDao: PizzaDao) : AndroidViewModel(app) {
    val db = DodoDataBase.getInstance(app).pizzaDao()
    val dataBase = DodoDataBase.getInstance(app).orderDao()

    fun insertViewMadel() {
        viewModelScope.launch(Dispatchers.IO) {

            Log.d("hello", "errrro")
            GetVkusList().getList().forEach {
                db.insertVkus(it)
            }
            GetPizzaList().getList().forEach() {
                db.insertPizza(it)
            }
            GetCategoryList().getCategory().forEach() {
                db.insertCotegory(it)
            }

            GetIngridientList().getList().forEach() {
                db.insertIngredient(it)
            }
            GetComboList().getList().forEach() {
                    db.insertCombo(it)
                }
                GetHalfList().getList().forEach {
                    db.insertHalfPizza(it)
                }
            GetStores().getList().forEach {
                    db.insertStores(it)
                }
               /* GetOrder().getList().forEach {
                   dataBase.newOrder(it)
                }*/
            }

    }


        fun getPizza(): LiveData<List<Pizza>> {
            return db.getAllPizza()
        }

        fun getVkus(size: Int): LiveData<List<Vkus>> {
            return db.getAllVkus(size)
        }
    fun getStores(id: Int): LiveData<List<StoryData>> {
            return db.getAllStores(id) }
        fun getMaineStores(maine: Boolean): LiveData<List<StoryData>> {
            return db.getMaineStores(maine)
        }

        fun getIngridient(id: Int): LiveData<List<Ingridients>> {
            return db.getIngredient(id)
        }

        fun getAllCotegory(): LiveData<List<Category>> {
            return db.getCotegory()
        }

        fun getAllSizeNormal(size: Int): LiveData<List<Pizza>> {
            return db.getAllSizeNormal(size)
        }

        fun getChoicePizza(things: Int, size: Int): LiveData<List<Pizza>> {
            return db.getThreePizza(things, size)
        }

        fun getCategory(category: String): LiveData<List<Pizza>> {
            return db.getCatedory(category)
        }

        fun getCategoryWithSize(category: String, size: Int): LiveData<List<Pizza>> {
            return db.getCatedoryWithSize(category, size)
        }
        fun getCombo(id: Int): LiveData<List<Pizza>> {
            return db.getAllCombo(id)
        }
    fun getComboPizza(id_pizza: Int): LiveData<List<Combo>> {
            return db.getComboPizza(id_pizza)
        }
    fun updateComboPizza(combo: Combo){
             db.updateComboPizza(combo)
        }

        fun getPizzaNameWithSize(name: String, size: Int): LiveData<List<Pizza>> {
            return db.getPizzaNameWithSize(name, size)
        }

        fun getPizzaName(name: String): LiveData<List<Pizza>> {
            return db.getPizzaName(name)
        }

    }