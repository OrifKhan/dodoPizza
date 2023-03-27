package com.example.dbfordodo.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "oderBay")
data class OrderBay (
@PrimaryKey
    val id:Int,
    val pizzaName:String,
    val pizzaImg:Int,
    val description : String,
    val about:String,
    val price:Int,
    val things:Int=1
        )