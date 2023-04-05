package com.example.dbfordodo.view.HelperClass

class ForDataSplash(){}/* SplashFragment(){
    lateinit var pizzaList:List<Pizza>




    val dataBase = DodoDataBase.getInstance(requireContext()).pizzaDao().getAllPizza()
       init {
           dataBase.observe(this){
pizzaList=it
           }
       }

    var hideBottomNavView = true

    private var _orderType = MutableLiveData(Constants.DOSTAVKA)
    val orderStreet : LiveData<String> get() = _orderType

    fun changeOrderType(type : String){
        _orderType.value = type
    }

    fun interestingList() : List<Pizza> {
        val newList = mutableListOf<Pizza>()

        for (pizza in 0..9) {
            var randomPizza = Random.nextInt(0,pizzaList.size)
            newList.add(pizzaList[randomPizza])
        }

        return newList
    }

    val categoryList =
        arrayListOf(
            Constants.PIZZA,
            Constants.COMBO,
            Constants.ZAKUSKI,
            Constants.DESERTI,
            Constants.NAPITKI,
            Constants.SOUSI,
            Constants.DRUGIE)
}*/