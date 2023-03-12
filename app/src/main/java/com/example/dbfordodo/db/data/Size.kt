package com.example.dbfordodo.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Size(
    @PrimaryKey
    val int: Int,

    val name:String
)
