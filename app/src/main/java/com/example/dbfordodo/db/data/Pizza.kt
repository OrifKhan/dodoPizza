package islom.din.dodo_ilmhona_proskills.db.data

import android.os.Parcelable
import androidx.compose.ui.geometry.Size
import androidx.navigation.fragment.FragmentNavigator
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "pizzaAll",
)
data class Pizza(
    @PrimaryKey(autoGenerate = true) val id:Int=0,
    val image:Int,
    val name:String,
    val about:String="",
    val price:Int,
    val category: String,
    val things: Int=1,
    var size:Int,
    var main: Boolean =false,
    var description: String?=null
):Parcelable {
    fun formatPriceSmall(): String {
        return "$price  TJS"
    }


    fun formatLitr1(): String {
        return "$size л"
    }
}


                                                  