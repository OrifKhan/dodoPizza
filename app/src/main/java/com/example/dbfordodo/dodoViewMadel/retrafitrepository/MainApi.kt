package com.example.dbfordodo.dodoViewMadel.retrafitrepository

import com.example.dbfordodo.db.data.Combo
import islom.din.dodo_ilmhona_proskills.db.data.Category
import islom.din.dodo_ilmhona_proskills.db.data.Ingridients
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import islom.din.dodo_ilmhona_proskills.db.data.Vkus
import islom.din.dodo_ilmhona_proskills.khq.dbMain.*
import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.StoryData
import retrofit2.Response
import retrofit2.http.GET

interface MainApi {
    @GET("pizzas")
    suspend fun getPizza(): Response<List<Pizza>>

    @GET("vkus")
    suspend fun getVkus(): Response<List<Vkus>>

    @GET("stores")
    suspend fun getStores(): Response<List<StoryData>>

    @GET("category")
    suspend fun getCategory(): Response<List<Category>>
    @GET("combo")
    suspend fun getCombo(): Response<List<Combo>>

    @GET("ingredient_size")
    suspend fun getIngredientSize(): Response<List<IngredientSize>>

    @GET("ingredient_size_connection")
    suspend fun getIngredientSizeConnection(): Response<List<IngredientSizeConnection>>

    @GET("ingredients_products_connection")
    suspend fun getIngredientSizeProducts(): Response<List<IngredientsProductsConnection>>

    @GET("ingredient")
    suspend fun getIngredient(): Response<List<Ingridients>>

    @GET("order_connection")
    suspend fun getOrdersConnection(): Response<List<OrderConnection>>

    @GET("order_connection_server")
    suspend fun getOrderConnection(): Response<List<OrderConnectionServer>>

    @GET("order_my")
    suspend fun getOrder(): Response<List<Order>>

}