    package islom.din.dodo_ilmhona_proskills.db.dao

    import androidx.lifecycle.LiveData
    import androidx.room.Dao
    import androidx.room.Insert
    import androidx.room.OnConflictStrategy
    import androidx.room.Query
    import islom.din.dodo_ilmhona_proskills.db.data.*

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

        @Query("SELECT * FROM ingredient WHERE id_pizza=:id")
        fun getIngredient(id:Int): LiveData<List<Ingridients>>

        //half pizza dao
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertHalfPizza(halfPizza: HalfPizza)

        @Query("SELECT * FROM half_pizza")
        fun gelAllHalfPizza(): LiveData<List<HalfPizza>>

        // vkus Pizza dao
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertVkus(vkus: Vkus)

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



    }