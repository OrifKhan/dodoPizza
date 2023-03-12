package islom.din.dodo_ilmhona_proskills.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "half_pizza")
data class HalfPizza (
    @PrimaryKey(autoGenerate = true) val id:Int,
    val image: Int,
    val name:String,
    val about:String,
    val price:Int
        )