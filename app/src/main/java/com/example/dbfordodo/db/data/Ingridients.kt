package islom.din.dodo_ilmhona_proskills.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredient")
data class Ingridients(
    @PrimaryKey(autoGenerate = true)val id : Int,
    val name : String,
    val available : Boolean = true,
    var delete : Boolean = false
)