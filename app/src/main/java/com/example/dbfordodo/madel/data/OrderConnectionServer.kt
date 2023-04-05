package com.example.dbfordodo.madel.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

@Entity(
    tableName = "order_connection_server",
    foreignKeys = [ForeignKey(
        Order::class,
        ["user_id"], ["users_id"],
        onDelete = ForeignKey.CASCADE
    ),
        ForeignKey(
            Pizza::class,
            ["id"], ["product_id"],
            onDelete = ForeignKey.CASCADE
        )]
)
data class OrderConnectionServer(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("order_id") val orderId: Int = 0,
    @ColumnInfo("users_id") val userId: Int = Constants.USER_ID,
    @ColumnInfo("product_id") val productId: Int,
    val amount: Int,
)