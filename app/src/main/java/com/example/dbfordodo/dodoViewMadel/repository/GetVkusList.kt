package com.example.dbfordodo.dodoViewMadel.repository

import com.example.dbfordodo.R

import islom.din.dodo_ilmhona_proskills.db.data.Vkus

class GetVkusList {
    fun getList() : List<Vkus> {
        val list = mutableListOf<Vkus>()

        list.add(Vkus(id = 0, R.raw.ingridient_1,"Брынза",  8,1))
        list.add(Vkus(id = 0, R.raw.ingridient_1,"Брынза",  10,  2))
        list.add(Vkus(id = 0, R.raw.ingridient_1,"Брынза",    13,3))

        list.add(Vkus(id = 0,R.raw.ingridient_2,"Ветчина  из цыплёнка", 7, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_2,"Ветчина  из цыплёнка", 10, 2))
        list.add(Vkus(id = 0,R.raw.ingridient_2,"Ветчина  из цыплёнка",  13,3))

        list.add(Vkus(id = 0,R.raw.ingridient_3,"Говядина",  8, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_3,"Говядина",  10,  2))
        list.add(Vkus(id = 0,R.raw.ingridient_3,"Говядина",    13,3))

        list.add(Vkus(id = 0,R.raw.ingridient_4,"Красный лук", 5, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_4,"Красный лук", 7,  2))
        list.add(Vkus(id = 0,R.raw.ingridient_4,"Красный лук",  9,3))

        list.add(Vkus(id = 0,R.raw.ingridient_5,"Маслины",  8, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_5,"Маслины",   10,  2))
        list.add(Vkus(id = 0,R.raw.ingridient_5,"Маслины",    13,3))

        list.add(Vkus(id = 0,R.raw.ingridient_6,"Солёные огурчики",  5, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_6,"Солёные огурчики",  7, 2))
        list.add(Vkus(id = 0,R.raw.ingridient_6,"Солёные огурчики",  9, 3))

        list.add(Vkus(id = 0,R.raw.ingridient_7,"Пикартная пепперони",  7,1 ))
        list.add(Vkus(id = 0,R.raw.ingridient_7,"Пикартная пепперони",  10,2 ))
        list.add(Vkus(id = 0,R.raw.ingridient_7,"Пикартная пепперони",   13,3 ))

        list.add(Vkus(id = 0,R.raw.ingridient_8,"Сладкий перец",  5, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_8,"Сладкий перец",  7,  2))
        list.add(Vkus(id = 0,R.raw.ingridient_8,"Сладкий перец",   9,3))

        list.add(Vkus(id = 0,R.raw.ingridient_9,"Итальянские травы",  5, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_9,"Итальянские травы",   7, 2))
        list.add(Vkus(id = 0,R.raw.ingridient_9,"Итальянские травы",   9,3))

        list.add(Vkus(id = 0,R.raw.ingridient_10,"Острая чоризо",  8, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_10,"Острая чоризо",   10, 2))
        list.add(Vkus(id = 0,R.raw.ingridient_10,"Острая чоризо",   13,3))
        list.add(Vkus(id = 0,R.raw.ingridient_11,"Смесь сыров Чеддер и Пармезан", 8, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_11,"Смесь сыров Чеддер и Пармезан", 10,  2))
        list.add(Vkus(id = 0,R.raw.ingridient_11,"Смесь сыров Чеддер и Пармезан",   13,3))

        list.add(Vkus(id = 0,R.raw.ingridient_12,"Cыр блю чиз",  9, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_12,"Cыр блю чиз",  11,  2))
        list.add(Vkus(id = 0,R.raw.ingridient_12,"Cыр блю чиз",    13,3))

        list.add(Vkus(id = 0,R.raw.ingridient_13,"Сырный бортик", 18, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_13,"Сырный бортик",  22,  2))
        list.add(Vkus(id = 0,R.raw.ingridient_13,"Сырный бортик",    25,3))

        list.add(Vkus(id = 0,R.raw.ingridient_14,"Томаты", 5, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_14,"Томаты", 7, 2))
        list.add(Vkus(id = 0,R.raw.ingridient_14,"Томаты", 9, 3))

        list.add(Vkus(id = 0,R.raw.ingridient_15,"Острый халапеньо",  5, 1, ))
        list.add(Vkus(id = 0,R.raw.ingridient_15,"Острый халапеньо",  7, 2, ))
        list.add(Vkus(id = 0,R.raw.ingridient_15,"Острый халапеньо",  8, 3, ))

        list.add(Vkus(id = 0,R.raw.ingridient_16,"Цыплёнок", 8, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_16,"Цыплёнок",  10,  2))
        list.add(Vkus(id = 0,R.raw.ingridient_16,"Цыплёнок",   13,3))
        list.add(Vkus(id = 0,R.raw.ingridient_17,"Шампиньоны", 8, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_17,"Шампиньоны",  10,  2))
        list.add(Vkus(id = 0,R.raw.ingridient_17,"Шампиньоны",   13,3))
        list.add(Vkus(id = 0,R.raw.ingridient_18,"Сыр моцарелла",  8, 1))
        list.add(Vkus(id = 0,R.raw.ingridient_18,"Сыр моцарелла",   10,  2))
        list.add(Vkus(id = 0,R.raw.ingridient_18,"Сыр моцарелла",  13,3))


        return list
    }
}