package com.example.dbfordodo.madel.daoInterface

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.dbfordodo.madel.data.Order
import com.example.dbfordodo.madel.data.OrderConnection
import com.example.dbfordodo.madel.data.OrderConnectionServer
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Insert
    suspend fun newOrder(order: Order)

    @Query("DELETE FROM order_connection WHERE users_id = :user_id")
    suspend fun deleteOrder(user_id: Int)

    @Query("SELECT * FROM order_connection WHERE users_id = :user_id")
    fun getOrderByUserId(user_id: Int) : List<OrderConnection>

    @Query("UPDATE order_connection SET amount = :amount " +
            "WHERE users_id = :user_id AND product_id = :product_id")
    fun updateOrderAmount(amount: Int,user_id: Int,product_id : Int)

    @Insert
    suspend fun insertOrderServer(list: List<OrderConnectionServer>)

    @Insert
    suspend fun newOrderConnection(orderConnection : OrderConnection)
@Query("SELECT * FROM order_connection_server")
    fun getHistoryOrders():LiveData<List<OrderConnectionServer>>
    @RewriteQueriesToDropUnusedColumns
    @Query("SELECT * FROM pizzaAll as p INNER JOIN order_connection as o " +
            "ON p.id = o.product_id AND o.users_id = :user_id")
    fun getOrderedProducts(user_id: Int) : Flow<List<Pizza>>

    @Query("SELECT SUM(p.price * o.amount) FROM pizzaAll as p INNER JOIN order_connection as o " +
            " ON p.id = o.product_id AND o.users_id =:user_id")
    fun getProductsSum(user_id: Int) : Flow<Int>

    @Query("SELECT amount FROM order_connection WHERE users_id = :user_id")
    fun getOrderedAmount(user_id: Int) : Flow<List<Int>>

    @Query("DELETE FROM order_connection WHERE users_id = :user_id AND product_id = :product_id")
    fun deleteOrder(user_id: Int,product_id: Int)
}