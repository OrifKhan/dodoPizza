package com.example.dbfordodo.madel.data

import androidx.room.*
import islom.din.dodo_ilmhona_proskills.db.data.Ingridients

@Entity(
    tableName = "ingredient_size_connection", foreignKeys = [ForeignKey(
        entity = IngredientSize::class,
        parentColumns = ["id"],
        childColumns = ["size_id"],
        onDelete = ForeignKey.CASCADE
    ),
        ForeignKey(
            entity = Ingridients::class,
            parentColumns = ["id"],
            childColumns = ["ingredient_id"],
            onDelete = ForeignKey.CASCADE
        )],
    indices = [Index(value = ["ingredient_id", "size_id", "price"], unique = true)]
)
data class IngredientSizeConnection(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo("ingredient_id") val ingredientId : Int,
    @ColumnInfo("size_id") val sizeId : Int,
    @ColumnInfo("price") val price : Int
)
