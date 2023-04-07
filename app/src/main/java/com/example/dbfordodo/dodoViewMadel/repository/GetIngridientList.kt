package com.example.dbfordodo.dodoViewMadel.repository

import islom.din.dodo_ilmhona_proskills.db.data.Ingridients


class GetIngridientList()  {
/*    fun getList() : MutableList<Ingridients> {

        val list = mutableListOf<Ingridients>()

        list.add(Ingridients(id=0,2,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,2,"салат свежий",false))
        list.add(Ingridients(id=0,2,"соус цезеарь",false))
        list.add(Ingridients(id=0,2,"томаты",))
        list.add(Ingridients(id=0,2,"смесь сыров чеддер и пармезан"))

        list.add(Ingridients(id=0,5,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,5,"томатный соус",false))
        list.add(Ingridients(id=0,5,"слаткий перец"))
        list.add(Ingridients(id=0,5,"острая чоризо из цыпленка"))

        list.add(Ingridients(id=0,8,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,8,"соус бургер",false))
        list.add(Ingridients(id=0,8,"ветчина хальяль",))
        list.add(Ingridients(id=0,8,"маринованные огурчики",))
        list.add(Ingridients(id=0,8,"красный лук",))
        list.add(Ingridients(id=0,8,"томаты",))

        list.add(Ingridients(id=0,11,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,11,"соус ранч",false))
        list.add(Ingridients(id=0,11,"соус бургер",false))
        list.add(Ingridients(id=0,11,"цыпленок"))
        list.add(Ingridients(id=0,11,"острая чоризо из цыпленка"))
        list.add(Ingridients(id=0,11,"сладкий перец"))
        list.add(Ingridients(id=0,11,"красный лук"))
        list.add(Ingridients(id=0,11,"томаты "))
        list.add(Ingridients(id=0,11,"чеснок "))

        list.add(Ingridients(id=0,14,"Увеличенная порция моцареллы",false))
        list.add(Ingridients(id=0,14,"томатный соус",false))
        list.add(Ingridients(id=0,14,"пепперони из цыпленка "))




//Додо
        list.add(Ingridients(id=0,17,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,17,"томатный соус",false))
        list.add(Ingridients(id=0,17,"пикантная пепперони из цыпленка"))
        list.add(Ingridients(id=0,17,"ветчина из цыпленка"))
        list.add(Ingridients(id=0,17,"митболы из говядины"))
        list.add(Ingridients(id=0,17,"томаты"))
        list.add(Ingridients(id=0,17,"сладкий перец"))
        list.add(Ingridients(id=0,17,"красный лук"))
        list.add(Ingridients(id=0,17,"шампиньоны"))
        list.add(Ingridients(id=0,17,"чеснок"))

//Диабло
        list.add(Ingridients(id=0,20,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,20,"томатный соус",false))
        list.add(Ingridients(id=0,20,"соус барбекю",false))
        list.add(Ingridients(id=0,20,"митболы из говядины"))
        list.add(Ingridients(id=0,20,"острая чоризо из цыпленка"))
        list.add(Ingridients(id=0,20,"острый перец халапеньо"))
        list.add(Ingridients(id=0,20,"сладкий перец"))
        list.add(Ingridients(id=0,20,"красный лук"))
        list.add(Ingridients(id=0,20,"томаты"))

//Сырная
        list.add(Ingridients(id=0,23,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,23,"соус альфредо",false))
        list.add(Ingridients(id=0,23,"смесь сыров чеддер и пармезан"))

//Пепперони фреш
        list.add(Ingridients(id=0,26,"Увеличенная порция моцареллы",false))
        list.add(Ingridients(id=0,26,"томатный соус",false))
        list.add(Ingridients(id=0,26,"пикантная пепперони из цыпленка"))
        list.add(Ingridients(id=0,26,"томаты"))


//Мясная
        list.add(Ingridients(id=0,29,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,29,"томатный соус",false))
        list.add(Ingridients(id=0,29,"цыпленок"))
        list.add(Ingridients(id=0,29,"пикантная пепперони из цыпленка"))
        list.add(Ingridients(id=0,29,"ветчина из цыпленка"))
        list.add(Ingridients(id=0,29,"острая чоризо из цыпленка"))

//Маргарита
        list.add(Ingridients(id=0,32,"Увеличенная порция моцареллы",false))
        list.add(Ingridients(id=0,32,"томатный соус",false))
        list.add(Ingridients(id=0,32,"томаты"))
        list.add(Ingridients(id=0,32,"итальянские травы"))

//Песто
        list.add(Ingridients(id=0,35,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,35,"соус альфредо",false))
        list.add(Ingridients(id=0,35,"соус песто",false))
        list.add(Ingridients(id=0,35,"цыпленок"))
        list.add(Ingridients(id=0,35,"кубики брынзы"))
        list.add(Ingridients(id=0,35,"томаты"))

//Двойная пепперони
        list.add(Ingridients(id=0,38,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,38,"томатный соус",false))
        list.add(Ingridients(id=0,38,"двойная порция пепперони из цыпленка"))

//Двойной цыпленок
        list.add(Ingridients(id=0,41,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,41,"соус альфредо",false))
        list.add(Ingridients(id=0,41,"цыпленок"))

//Ветчина и сыр
        list.add(Ingridients(id=0,44,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,44,"соус альфредо",false))
        list.add(Ingridients(id=0,44,"ветчина из цыпленка"))

//Карбонара
        list.add(Ingridients(id=0,47,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,47,"соус альфредо",false))
        list.add(Ingridients(id=0,47,"ветчина из цыпленка"))
        list.add(Ingridients(id=0,47,"смесь сыров чеддер и пармезан"))
        list.add(Ingridients(id=0,47,"томаты"))
        list.add(Ingridients(id=0,47,"красный лук"))
        list.add(Ingridients(id=0,47,"чеснок"))
        list.add(Ingridients(id=0,47,"итальянские травы"))

//Четыре сыра
        list.add(Ingridients(id=0,50,"Увеличенная порция моцареллы",false))
        list.add(Ingridients(id=0,50,"соус альфредо",false))
        list.add(Ingridients(id=0,50,"смесь сыров чеддер и пармезан"))
        list.add(Ingridients(id=0,50,"сыр блю чиз"))

//Четыре сезона
        list.add(Ingridients(id=0,53,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,53,"томатный соус",false))
        list.add(Ingridients(id=0,53,"пикантная пепперони из цыпленка"))
        list.add(Ingridients(id=0,53,"ветчина из цыпленка"))
        list.add(Ingridients(id=0,53,"шампиньоны"))
        list.add(Ingridients(id=0,53,"кубики брынзы"))
        list.add(Ingridients(id=0,53,"томаты"))
        list.add(Ingridients(id=0,53,"итальянские травы"))

//Овощи и грибы
        list.add(Ingridients(id=0,56,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,56,"томатный соус",false))
        list.add(Ingridients(id=0,56,"сладкий перец"))
        list.add(Ingridients(id=0,56,"красный лук"))
        list.add(Ingridients(id=0,56,"томаты"))
        list.add(Ingridients(id=0,56,"кубики брынзы"))
        list.add(Ingridients(id=0,56,"маслины"))
        list.add(Ingridients(id=0,56,"шампиньоны"))
        list.add(Ingridients(id=0,56,"итальянские травы"))


//Деревенская
        list.add(Ingridients(id=0,59,"Сыр моцарелла",false))
        list.add(Ingridients(id=0,59,"томатный соус",false))
        list.add(Ingridients(id=0,59,"соус ранч",false))
        list.add(Ingridients(id=0,59,"цыпленок"))
        list.add(Ingridients(id=0,59,"картофель из печи"))
        list.add(Ingridients(id=0,59,"красный лук"))
        list.add(Ingridients(id=0,59,"томаты"))
        list.add(Ingridients(id=0,59,"маринованные огурчики"))
        list.add(Ingridients(id=0,59,"чеснок"))


//Ветчина и грибы
        list.add(Ingridients(id=0,62,"Увеличенная порция моцареллы",false))
        list.add(Ingridients(id=0,62,"томатный соус",false))
        list.add(Ingridients(id=0,62,"ветчина из цыпленка"))
        list.add(Ingridients(id=0,62,"шампиньоны"))




        return list
    }*/
}