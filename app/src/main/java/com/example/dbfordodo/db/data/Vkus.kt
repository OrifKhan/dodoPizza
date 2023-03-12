package islom.din.dodo_ilmhona_proskills.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vkus")
data class Vkus(
    @PrimaryKey(autoGenerate = true) val id : Int=0,
    val image : Int,
    val name : String,
    val priceSmall :Int,
    val priceNormal :Int,
    val priceBig :Int,
    val available : Boolean? = true,
    var select : Boolean? = false,
)