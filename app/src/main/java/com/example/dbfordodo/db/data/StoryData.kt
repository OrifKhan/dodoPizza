package islom.din.dodo_ilmhona_proskills.shodmon.khushbakht

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "stores",)

data class StoryData(
   @PrimaryKey(autoGenerate = true) val id : Int,
   val idItem:Int,
    val image :Int,
    var main: Boolean =false
)
