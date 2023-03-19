package com.example.dbfordodo.db.dao.dbMain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import islom.din.dodo_ilmhona_proskills.db.dao.PizzaDao
import islom.din.dodo_ilmhona_proskills.db.data.*
import islom.din.dodo_ilmhona_proskills.khq.dbMain.*


@Database(
    entities = [Pizza::class, Category::class, HalfPizza::class, Ingridients::class, Vkus::class,
        Ingredients::class, IngredientSize::class, IngredientSizeConnection::class,
        IngredientsProductsConnection::class, Products::class, Order::class, OrderConnection::class,
        OrderConnectionServer::class],
    version = 1
)

abstract class DodoDataBase: RoomDatabase() {
    abstract fun pizzaDao():PizzaDao

    abstract fun ingredientsDao() : IngredientsDao

    abstract fun ingredientProductsConnectionDao() : IngredientsProductsConnectionDao

    abstract fun productsDao() : ProductsDao

    abstract fun orderDao() : OrderDao

    companion object{
        @Volatile
        private var INSTANCE: DodoDataBase? =null

        fun getInstance(context: Context): DodoDataBase {
            return  INSTANCE ?:synchronized(this){
                val instance=Room.databaseBuilder(context.applicationContext,
                DodoDataBase::class.java,
                "dodo_base")
                    .build()
                INSTANCE =instance

                instance
            }

        }
    }
}

