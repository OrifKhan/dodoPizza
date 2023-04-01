    package islom.din.dodo_ilmhona_proskills.db.dao

    import androidx.lifecycle.LiveData
    import androidx.room.*
    import com.example.dbfordodo.db.data.Combo
    import islom.din.dodo_ilmhona_proskills.db.data.*
    import islom.din.dodo_ilmhona_proskills.khq.dbMain.OrderConnectionServer
    import islom.din.dodo_ilmhona_proskills.shodmon.khushbakht.StoryData
    import kotlinx.coroutines.flow.Flow

    @Dao
    interface PizzaDao {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertPizza(pizza: Pizza)

        @Query("SELECT * FROM pizzaAll")
        fun getAllPizza(): LiveData<List<Pizza>>

        //cotegory dao
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertCotegory(category: Category)

        @Query("SELECT * FROM category")
        fun getCotegory(): LiveData<List<Category>>

        //Ingredient
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertIngredient(ingridients: Ingridients)

        @Query("SELECT * FROM ingridient WHERE id_pizza=:id")
        fun getIngredient(id:Int): LiveData<List<Ingridients>>

        //half pizza dao
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertHalfPizza(halfPizza: HalfPizza)

        @Query("SELECT * FROM half_pizza")
        fun gelAllHalfPizza(): LiveData<List<HalfPizza>>

        // vkus Pizza dao
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertVkus(vkus: Vkus)
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertStores(stores:StoryData)
        @Query("SELECT * FROM stores WHERE idItem=:id")
         fun getAllStores(id: Int):LiveData<List<StoryData>>
         @Query("SELECT * FROM stores WHERE main =:maine")
         fun getMaineStores(maine: Boolean):LiveData<List<StoryData>>


        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertCombo(combo: Combo)

        @Query("SELECT * FROM pizzaAll as p INNER JOIN combo as c ON  p.id=c.id_pizza AND c.id_combo=:id_combo")
        fun getAllCombo(id_combo:  Int): LiveData<List<Pizza>>
        @Query("SELECT * FROM combo WHERE id = :id")
        fun getComboPizza(id: Int): LiveData<List<Combo>>
        @Query("Update combo set id_pizza =:id_pizza Where id=:id")
       suspend fun updateComboPizza(id: Int,id_pizza: Int)
        @Query("SELECT * FROM vkus WHERE size = :size")
        fun getAllVkus(size: Int): LiveData<List<Vkus>>

        @Query("SELECT * FROM pizzaAll WHERE size = :size")
        fun getAllSizeNormal(size: Int): LiveData<List<Pizza>>
        @Query("SELECT * FROM pizzaAll WHERE  id < :things AND size = :siz")
        fun getThreePizza(things: Int,siz: Int): LiveData<List<Pizza>>
        @Query("SELECT * FROM pizzaAll WHERE  category = :category AND size=:size")
        fun getCatedoryWithSize(category: String,size: Int): LiveData<List<Pizza>>
        @Query("SELECT * FROM pizzaAll WHERE  category = :category")
        fun getCatedory(category: String): LiveData<List<Pizza>>
        @Query("SELECT * FROM pizzaAll WHERE  name= :name AND size =:size")
        fun getPizzaNameWithSize(name: String, size: Int): LiveData<List<Pizza>>
        @Query("SELECT * FROM pizzaAll WHERE  name= :name")
        fun getPizzaName(name: String): LiveData<List<Pizza>>
        @RewriteQueriesToDropUnusedColumns
        @Query("SELECT * FROM pizzaAll as p INNER JOIN order_connection_server as o " +
                "ON p.id = o.product_id AND o.users_id = :user_id")
        fun getPizzaId(user_id: Int) : Flow<List<Pizza>>



    }