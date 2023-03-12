package com.example.dbfordodo.dodoViewMadel.repository

import islom.din.dodo_ilmhona_proskills.db.data.Ingridients


class GetIngridientList()  {
    fun getList() : MutableList<Ingridients> {

        val list = mutableListOf<Ingridients>()

        list.add(Ingridients(id = 0, name = "NOTHING"))
        list.add(Ingridients(id = 0, name = "Соус альфредо",false))
        list.add(Ingridients(id = 0, name = "Мандарины"))
        list.add(Ingridients(id = 0 , name = "Цитровый соус",false))
        list.add(Ingridients(id = 0 , name = "Новогодгый соус",))
        list.add(Ingridients(id = 0 , name = "Cыр моцарелла",false))
        list.add(Ingridients(id = 0 , name = "Красный лук"))
        list.add(Ingridients(id = 0 , name = "Солёные огурчики"))
        list.add(Ingridients(id = 0 , name = "Томаты"))
        list.add(Ingridients(id = 0 , name = "Соус бургер",false))
        list.add(Ingridients(id = 0 , name = "Ветчина халяль",false))
        list.add(Ingridients(id = 0 , name = "Сыр моцарелла",false))
        list.add(Ingridients(id = 0 , name = "Цыплёнок"))
        list.add(Ingridients(id = 0 , name = "Соус ранч"))
        list.add(Ingridients(id = 0 , name = "Острая чоризо из цыплёнка"))
        list.add(Ingridients(id = 0 , name = "Сладкий перец"))
        list.add(Ingridients(id = 0 , name = "Чеснок"))
        list.add(Ingridients(id = 0 , name = "Пепперони из цыплёнка"))
        list.add(Ingridients(id = 0 , name = "Томатный соус",false))
        list.add(Ingridients(id = 0 , name = "Увеличенная порция моцареллы",false))
        list.add(Ingridients(id = 0 , name = "NOTHING",false))
        list.add(Ingridients(id = 0 , name = "Ветчина из цыплёнка"))
        list.add(Ingridients(id = 0 , name = "Митболы из говдины"))
        list.add(Ingridients(id = 0 , name = "Пикатная пепперони из цыплёнка"))
        list.add(Ingridients(id = 0 , name = "Шампиньоны"))
        list.add(Ingridients(id = 0 , name = "Моцарелла"))
        list.add(Ingridients(id = 0 , name = "Острый перец халапеньо"))
        list.add(Ingridients(id = 0 , name = "Соус барбекю"))
        list.add(Ingridients(id =0 , name = "Митболы из говядины"))
        list.add(Ingridients(id = 0 , name = "Томаты"))
        list.add(Ingridients(id = 0 , name = "Томаты"))

        var couter =0
        var text = "Смесь сыров чеддер и пармезан, соус альфредо, моцарелла".split(",")

        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Пикатна пепперони из цыплёнка, том аты, томаный соус, увеличенная порция моцаррелы".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Цыплёнок, ветчина из цыплёнка, пикантная пепперони из цыплёнка, томатный соус, острая чоризо из цыплёнка, сыр моцарелла".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Томаты, итальянские травы, томатный соус, увеличенная порция моцареллы".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Соус песто, соус альфредо, цыплёнок, кубики брынзы, томаты, моцарелла".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Пепперони из цыплёнка, томатный соус, моцарелла".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Цыплёнок, соу альфредо, моцарелла".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Ветчина из цыплёнка, сыр моцарелла, соус альфредо".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус фльфредо".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус альфредо".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Сыр моцарлла, ветчина из цыплёнка, пикантная пепперони из цыплёнка, кубики брынзф, томаты, шампиньогы, томатный соус, итальянские травы".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Картофель из печи, огурцы маринованные, цыплёнок, соус, чесночный ранч, томаты свежие, лук красный, чеснок, пицца-соус, сыр моцалрелла".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }

        text = "Ветчина из цыплёнка, шампиньоны, томатный соус, увеличенная порция моцареллы".split(",")
        for (i in text){
            list.add(Ingridients(id = couter, name = i))

        }






        return list
    }
}