package islom.din.dodo_ilmhona_proskills.khq.dbMain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import islom.din.dodo_ilmhona_proskills.db.data.Pizza
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {
    @Insert
    suspend fun insertAll(vararg product: Pizza)

    @Update
    suspend fun update(product: Pizza)

    @Query("SELECT * FROM pizzaAll")
    fun getAllProducts() : Flow<List<Pizza>>

}