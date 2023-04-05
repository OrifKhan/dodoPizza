package com.example.dbfordodo.madel.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

@Entity(
    tableName = "combo", foreignKeys = [ForeignKey(
        entity = Pizza::class,
        parentColumns = ["id"],
        childColumns = ["id_combo"],
        onDelete = ForeignKey.CASCADE
    ),
        ForeignKey(
            entity = Pizza::class,
            parentColumns = ["id"],
            childColumns = ["id_pizza"],
            onDelete = ForeignKey.CASCADE
        )]
)
data class Combo(
    @PrimaryKey(autoGenerate = true)val id: Int,
    val id_combo: Int,
    val id_pizza: Int,

    )
