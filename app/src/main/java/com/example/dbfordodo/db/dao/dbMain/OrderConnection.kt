package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.dbfordodo.db.data.Constants
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

@Entity(
    tableName = "order_connection",
    foreignKeys = [ForeignKey(
        Order::class,
        ["user_id"], ["users_id"],
        onDelete = ForeignKey.CASCADE
    ),
        ForeignKey(
            Pizza::class,
            parentColumns = ["id"],
            childColumns = ["product_id"],
            onDelete = ForeignKey.CASCADE
        )]
)
data class OrderConnection(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("order_id") val orderId: Int = 0,
    @ColumnInfo("users_id") val userId: Int = Constants.USER_ID,
    @ColumnInfo("product_id") val productId: Int,
    val amount: Int,
)
