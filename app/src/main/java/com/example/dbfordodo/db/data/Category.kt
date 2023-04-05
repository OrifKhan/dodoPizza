package islom.din.dodo_ilmhona_proskills.db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category (
   @PrimaryKey(autoGenerate = true) val id:Int,
    val name: String,
   val isChecked:Int=0
        )