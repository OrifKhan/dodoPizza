package islom.din.dodo_ilmhona_proskills.db.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ingridient", foreignKeys = [ForeignKey(
        entity = Pizza::class,
        parentColumns = ["id"],
        childColumns = ["id_pizza"],
        onDelete = ForeignKey.CASCADE
    )]
)

data class Ingridients(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val id_pizza: Int,
    val name: String,
    val available: Boolean = true,
    var delete: Boolean = false,
)