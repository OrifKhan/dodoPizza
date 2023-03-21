package islom.din.dodo_ilmhona_proskills.shodmon.khushbakht

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "storis", foreignKeys = [ForeignKey(entity = ImageData::class,
parentColumns = ["image"], childColumns =[ "image"],
onDelete = ForeignKey.CASCADE)])

data class StoryData(
    val id : Int,
    val id_item:Int,
    val image :Int
)
