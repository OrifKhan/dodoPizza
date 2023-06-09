package com.example.dbfordodo.madel.daoInterface

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dbfordodo.madel.data.IngredientSize
import com.example.dbfordodo.madel.data.IngredientSizeConnection


@Dao
interface IngredientsDao {


   /* @Query("SELECT * FROM ingridient")
    fun getAllIngredients() : List<Ingridients>*/

    @Insert
    suspend fun addIngredientSizeConnection(vararg ingredientSizeConnection: IngredientSizeConnection)

    @Query("SELECT * FROM ingredient_size_connection WHERE ingredient_id = :ingredient_id")
    fun getIngredientSizeConnection(ingredient_id: Int) : List<IngredientSizeConnection>

    @Insert
    suspend fun addIngredientSize(vararg ingredientSize: IngredientSize)

    @Query("SELECT id FROM ingredient_size WHERE ingredient_size = :size")
    fun getSizeId (size: String) : List<Int>
}