package com.example.dbfordodo.madel.daoInterface

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dbfordodo.madel.data.IngredientsProductsConnection


@Dao
interface IngredientsProductsConnectionDao {
    @Insert
    suspend fun insertAll(ingredientsProductsConnection: IngredientsProductsConnection)

    @Query("SELECT * FROM ingredients_products_connection WHERE products_id = :productsId")
    fun getAllIngredientsByProductsId(productsId: Int) : List<IngredientsProductsConnection>
}