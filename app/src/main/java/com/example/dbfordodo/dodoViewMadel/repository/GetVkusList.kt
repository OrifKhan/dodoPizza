package com.example.dbfordodo.dodoViewMadel.repository

import com.example.dbfordodo.R

import islom.din.dodo_ilmhona_proskills.db.data.Vkus

class GetVkusList {
    fun getList() : List<Vkus> {
        val list = mutableListOf<Vkus>()

        list.add(Vkus(id = 0, R.raw.ingridient_1,"Брынза",  8,10,  13))
        list.add(Vkus(id = 0,R.raw.ingridient_2,"Ветчина  из цыплёнка", 7, 10,  13))
        list.add(Vkus(id = 0,R.raw.ingridient_3,"Говядина",  8, 10,  13))
        list.add(Vkus(id = 0,R.raw.ingridient_4,"Красный лук", 5, 7,  9))
        list.add(Vkus(id = 0,R.raw.ingridient_5,"Маслины",  8, 10,  13))
        list.add(Vkus(id = 0,R.raw.ingridient_6,"Солёные огурчики",  5, 7,  9))
        list.add(Vkus(id = 0,R.raw.ingridient_7,"Пикартная пепперони",  7,10,  13 ))
        list.add(Vkus(id = 0,R.raw.ingridient_8,"Сладкий перец",  5, 7,  9))
        list.add(Vkus(id = 0,R.raw.ingridient_9,"Итальянские травы",  5, 7, 9))
        list.add(Vkus(id = 0,R.raw.ingridient_10,"Острая чоризо",  8, 10, 13))
        list.add(Vkus(id = 0,R.raw.ingridient_11,"Смесь сыров Чеддер и Пармезан", 8, 10,  13))
        list.add(Vkus(id = 0,R.raw.ingridient_12,"Cыр блю чиз",  9, 11,  13))
        list.add(Vkus(id = 0,R.raw.ingridient_13,"Сырный бортик", 18, 22,  25))
        list.add(Vkus(id = 0,R.raw.ingridient_13,"Сырный бортик",  18, 22,  25))
        list.add(Vkus(id = 0,R.raw.ingridient_14,"Томаты", 5, 8,  10))
        list.add(Vkus(id = 0,R.raw.ingridient_15,"Острый халапеньо",  5, 7, 8))
        list.add(Vkus(id = 0,R.raw.ingridient_16,"Цыплёнок", 8, 10,  13))
        list.add(Vkus(id = 0,R.raw.ingridient_17,"Шампиньоны", 8, 10,  13))
        list.add(Vkus(id = 0,R.raw.ingridient_18,"Сыр моцарелла",  8, 10,  13))


        return list
    }
}