package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.*
import islom.din.dodo_ilmhona_proskills.db.data.Ingridients
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

@Entity(
    tableName = "ingredients_products_connection", foreignKeys = [ForeignKey(
        entity = Pizza::class,
        parentColumns = ["id"],
        childColumns = ["products_id"],
        onDelete = ForeignKey.CASCADE
    ),
        ForeignKey(
            entity = Ingridients::class,
            parentColumns = ["id"],
            childColumns = ["ingredients_id"],
            onDelete = ForeignKey.CASCADE
        )],
    indices = [Index(value = ["ingredients_id", "products_id"], unique = true)]
)
data class IngredientsProductsConnection(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo("ingredients_id")val ingredientsId : Int,
    @ColumnInfo("products_id") val productsId: Int,
)
