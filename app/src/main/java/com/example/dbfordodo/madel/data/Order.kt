package com.example.dbfordodo.madel.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "order_my", indices = [Index(value = ["user_id"], unique = true)])
data class Order (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo("user_id") val userId : Int
)