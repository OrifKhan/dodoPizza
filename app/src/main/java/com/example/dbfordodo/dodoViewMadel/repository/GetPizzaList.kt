package com.example.dbfordodo.dodoViewMadel.repository

import com.example.dbfordodo.R
import com.example.dbfordodo.db.data.Constants
import islom.din.dodo_ilmhona_proskills.db.data.Pizza

class GetPizzaList {
    fun getList(): List<Pizza> {


        val list = mutableListOf<Pizza>()


        list.add(
            Pizza(0, R.raw.ima1_2,"Бургер пицца","Красный лук, сольёные огурчики, томаты, соус бургер, ветчина залясь, сыр моцарелла",
                54,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_2,"Бургер пицца","Красный лук, сольёные огурчики, томаты, соус бургер, ветчина залясь, сыр моцарелла",
                79,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img2_2,"Бургер пицца","Красный лук, сольёные огурчики, томаты, соус бургер, ветчина залясь, сыр моцарелла",
                96,Constants.PIZZA, size = 3))

        list.add(
            Pizza(0, R.raw.ima1_3,"Аррива","Сыр моцарелла, соус бургер,цыплёнок, соус ранч, острая чоризо из цыплёнка, сладкий перец, красный лук, томаты, чеснок",
                54,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_3,"Аррива","Сыр моцарелла, соус бургер,цыплёнок, соус ранч, острая чоризо из цыплёнка, сладкий перец, красный лук, томаты, чеснок",
                79,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img2_3,"Аррива","Сыр моцарелла, соус бургер,цыплёнок, соус ранч, острая чоризо из цыплёнка, сладкий перец, красный лук, томаты, чеснок",
                96,Constants.PIZZA, size = 3))


        list.add(
            Pizza(0, R.raw.ima1_4,"Пепперони","Пепперони из цыплёнка, томатный соус, увеличенная порция моцареллы",
                54,Constants.PIZZA, size = 1)
        )
        list.add(
            Pizza(0, R.raw.img_4,"Пепперони","Пепперони из цыплёнка, томатный соус, увеличенная порция моцареллы",
                79,Constants.PIZZA, size = 2)
        )
        list.add(
            Pizza(0, R.raw.img2_4,"Пепперони","Пепперони из цыплёнка, томатный соус, увеличенная порция моцареллы",
                96,Constants.PIZZA, size = 3)
        )


        list.add(
            Pizza(0, R.raw.ima1_5,"Додо","Ветчина из цыплёнка, митоболы из говядины, пикантная пепперони из цыплёнка, томаты, шампиньоны, сладкий перей, красный лук, чеснок, томатный соус, моцарелла",
                60,Constants.PIZZA, size = 1)
        )
        list.add(
            Pizza(0, R.raw.img_5,"Додо","Ветчина из цыплёнка, митоболы из говядины, пикантная пепперони из цыплёнка, томаты, шампиньоны, сладкий перей, красный лук, чеснок, томатный соус, моцарелла",
                90,Constants.PIZZA, size = 2)
        )
        list.add(
            Pizza(0, R.raw.img2_5,"Додо","Ветчина из цыплёнка, митоболы из говядины, пикантная пепперони из цыплёнка, томаты, шампиньоны, сладкий перей, красный лук, чеснок, томатный соус, моцарелла",
                112,Constants.PIZZA, size = 3)
        )

        list.add(
            Pizza(0, R.raw.ima1_6,"Диалбло","Острая чоризо из цыплёнка, острый перец холапеньо, соус барбекю, митболы из говядины, томаты, сладкий перец, красный лук, томатный соус, моцарелла",
                58,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_6,"Диалбло","Острая чоризо из цыплёнка, острый перец холапеньо, соус барбекю, митболы из говядины, томаты, сладкий перец, красный лук, томатный соус, моцарелла",
                88,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img2_6,"Диалбло","Острая чоризо из цыплёнка, острый перец холапеньо, соус барбекю, митболы из говядины, томаты, сладкий перец, красный лук, томатный соус, моцарелла",
                110,Constants.PIZZA, size = 3))
        list.add(
            Pizza(0, R.raw.ima1_7,"Сырная","Смесь сыров чеддер и пармезан, соус альфредо, моцарелла",
                39,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_7,"Сырная","Смесь сыров чеддер и пармезан, соус альфредо, моцарелла",
              66,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img2_7,"Сырная","Смесь сыров чеддер и пармезан, соус альфредо, моцарелла",
              86,Constants.PIZZA, size = 3))


        list.add(
            Pizza(0, R.raw.ima1_9,"Пепперони Фреш","Пикатна пепперони из цыплёнка, томаты, томаный соус, увеличенная порция моцаррелы",
                37,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_9,"Пепперони Фреш","Пикатна пепперони из цыплёнка, томаты, томаный соус, увеличенная порция моцаррелы",
                60,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img_9,"Пепперони Фреш","Пикатна пепперони из цыплёнка, томаты, томаный соус, увеличенная порция моцаррелы",
               74,Constants.PIZZA, size = 3))


        list.add(
            Pizza(0, R.raw.ima1_10,"Мясная","Цыплёнок, ветчина из цыплёнка, пикантная пепперони из цыплёнка, томатный соус, острая чоризо из цыплёнка, сыр моцарелла",
                60,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_10,"Мясная","Цыплёнок, ветчина из цыплёнка, пикантная пепперони из цыплёнка, томатный соус, острая чоризо из цыплёнка, сыр моцарелла",
                90,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img2_10,"Мясная","Цыплёнок, ветчина из цыплёнка, пикантная пепперони из цыплёнка, томатный соус, острая чоризо из цыплёнка, сыр моцарелла",
                112,Constants.PIZZA, size = 3))


        list.add(
            Pizza(0, R.raw.ima1_11,"Маргарита","Томаты, итальянские травы, томатный соус, увеличенная порция моцареллы",
                44,Constants.PIZZA, size = 1) )

                    list.add(
            Pizza(0, R.raw.img_11,"Маргарита","Томаты, итальянские травы, томатный соус, увеличенная порция моцареллы",
                66,Constants.PIZZA, size = 2) )
                    list.add(
            Pizza(0, R.raw.img2_11,"Маргарита","Томаты, итальянские травы, томатный соус, увеличенная порция моцареллы",
                86,Constants.PIZZA, size = 3)
        )

        list.add(
            Pizza(0, R.raw.ima1_12,"Песто","Соус песто, соус альфредо, цыплёнок, кубики брынзы, томаты, моцарелла",
                60,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_12,"Песто","Соус песто, соус альфредо, цыплёнок, кубики брынзы, томаты, моцарелла",
                90,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img_12,"Песто","Соус песто, соус альфредо, цыплёнок, кубики брынзы, томаты, моцарелла",
                112,Constants.PIZZA, size = 3))



        list.add(
            Pizza(0, R.raw.ima1_13,"Двойная пепперони","Пепперони из цыплёнка, томатный соус, моцарелла",
                60,Constants.PIZZA, size = 1))

        list.add(
            Pizza(0, R.raw.img_13,"Двойная пепперони","Пепперони из цыплёнка, томатный соус, моцарелла",
                90,Constants.PIZZA, size = 2))

        list.add(
            Pizza(0, R.raw.img2_13,"Двойная пепперони","Пепперони из цыплёнка, томатный соус, моцарелла",
                112,Constants.PIZZA, size = 3))



        list.add(
            Pizza(0, R.raw.ima1_14,"Двойной цыплёнок","Цыплёнок, соу альфредо, моцарелла",
                37,Constants.PIZZA, size = 1))

        list.add(
            Pizza(0, R.raw.img_14,"Двойной цыплёнок","Цыплёнок, соу альфредо, моцарелла",
                60,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img2_14,"Двойной цыплёнок","Цыплёнок, соу альфредо, моцарелла",
                74,Constants.PIZZA, size = 3))



        list.add(
            Pizza(0, R.raw.ima1_15,"Ветчина и сыр","Ветчина из цыплёнка, сыр моцарелла, соус альфредо",
                39,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_15,"Ветчина и сыр","Ветчина из цыплёнка, сыр моцарелла, соус альфредо",
                60,Constants.PIZZA, size = 2))
          list.add(
                    Pizza(0, R.raw.img2_15,"Ветчина и сыр","Ветчина из цыплёнка, сыр моцарелла, соус альфредо",
                        74,Constants.PIZZA, size = 3))



        list.add(
            Pizza(0, R.raw.ima1_16,"Карбонара","Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус фльфредо",
                60,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_16,"Карбонара","Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус фльфредо",
                79,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img2_16,"Карбонара","Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус фльфредо",
                90,Constants.PIZZA, size = 3))



        list.add(
            Pizza(0, R.raw.ima1_17,"Четыре сыра","Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус альфредо",
                37,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_17,"Четыре сыра","Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус альфредо",
                60,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img2_17,"Четыре сыра","Увеличенная порция моцареллы, смесь сыров чеддер и пармезан, сыр блю чиз, соус альфредо",
                122,Constants.PIZZA, size = 3))


        list.add(
            Pizza(0, R.raw.ima1_18,"Четыре сезона","Сыр моцарлла, ветчина из цыплёнка, пикантная пепперони из цыплёнка, кубики брынзф, томаты, шампиньогы, томатный соус, итальянские травы",
                58,Constants.PIZZA, size = 1))
    list.add(
            Pizza(0, R.raw.img_18,"Четыре сезона","Сыр моцарлла, ветчина из цыплёнка, пикантная пепперони из цыплёнка, кубики брынзф, томаты, шампиньогы, томатный соус, итальянские травы",
                88,Constants.PIZZA, size = 2))
    list.add(
            Pizza(0, R.raw.img2_18,"Четыре сезона","Сыр моцарлла, ветчина из цыплёнка, пикантная пепперони из цыплёнка, кубики брынзф, томаты, шампиньогы, томатный соус, итальянские травы",
                110,Constants.PIZZA, size = 3))


        list.add(
            Pizza(0, R.raw.ima1_19,"Деревенская","Картофель из печи, огурцы маринованные, цыплёнок, соус, чесночный ранч, томаты свежие, лук красный, чеснок, пицца-соус, сыр моцалрелла",
                58,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_19,"Деревенская","Картофель из печи, огурцы маринованные, цыплёнок, соус, чесночный ранч, томаты свежие, лук красный, чеснок, пицца-соус, сыр моцалрелла",
                110,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img2_19,"Деревенская","Картофель из печи, огурцы маринованные, цыплёнок, соус, чесночный ранч, томаты свежие, лук красный, чеснок, пицца-соус, сыр моцалрелла",
                110,Constants.PIZZA, size = 3))


        list.add(
            Pizza(0, R.raw.ima1_20,"Ветчина и грибы","Ветчина из цыплёнка, шампиньоны, томатный соус, увеличенная порция моцареллы",
                44,Constants.PIZZA, size = 1))
        list.add(
            Pizza(0, R.raw.img_20,"Ветчина и грибы","Ветчина из цыплёнка, шампиньоны, томатный соус, увеличенная порция моцареллы",
                66,Constants.PIZZA, size = 2))
        list.add(
            Pizza(0, R.raw.img2_20,"Ветчина и грибы","Ветчина из цыплёнка, шампиньоны, томатный соус, увеличенная порция моцареллы",
                88,Constants.PIZZA, size = 3))


        list.add(
            Pizza(0, R.raw.img_21,"3 пиццы","Комбо 2 пиццы 30см на любой вкус",
                price = 225, category = Constants.COMBO, things = 30, size = 2)
            )


        list.add(
            Pizza(0, R.raw.img_22,"10 средних пицц","10 пицц 30см на любой вкусу. Для компании из 20-30 человек",
                price = 675, category = Constants.COMBO, things = 100, size = 2))


        list.add(
            Pizza(0, R.raw.img_23,"2 пиццы","Самое популяроне комбо из 2 пицц 30см. Большой выбор",
                156, category = Constants.COMBO, things = 20, size = 2
            )
        )

        list.add(
            Pizza(0, R.raw.img_24,"7 пицц","7 пицц 30см на любой вкус. Для компании из 15-20 человек",
                470, category = Constants.COMBO, things = 70, size = 2) )

        list.add(
            Pizza(0, R.raw.img_25,"2 пиццы и напиток","2 пиццы 25 см и напиток на выбор, Для компании из 2-4 человек",
                99, category = Constants.COMBO, things = 201, size = 2)
        )

        list.add(
            Pizza(0, R.raw.img_26,"Пицца и 2 закуски","Пицца 30см и 2 закуски на выбор. Для компании из 2-4 человек",
                110, category = Constants.COMBO, things = 1023, size = 2 )
        )

        list.add(
            Pizza(0, R.raw.img_27,"4 Додстера","4 любых Додстера на выбор: Отсрый или Классический",
                89, category = Constants.COMBO, things = 44 , size = 2)
        )

        list.add(
            Pizza(0, R.raw.img_28,"Пицца, додстер, напиток и соус","Пицца 25см, додстер, напиток и соус. Для компании из 2-4 человек",
                85, category = Constants.COMBO, things = 1014105 , size = 2)
        )

        list.add(
            Pizza(0, R.raw.img_29,"2 стартера","2 стартера",
                45, category = Constants.COMBO, things = 25, size = 2)
        )

        list.add(
            Pizza(0, R.raw.img_31,"Две Кока-Колы Zero по суперцене","Две Кока-Колы Zero 0,5 по суперцене",
                10, category = Constants.COMBO, size = 1
        )
        )
        list.add(
            Pizza(id = 0, image = R.raw.ima_32, name = "Сырные палочки с песто + Соус Ранч", about = "Сытный перекус для компании. На пышном тесте — только песто и сыр. И соус ранч/чесночный в комплекте — с ним вкуснее!",
                price = 33, category = Constants.ZAKUSKI, things = 1, size = 2))
        list.add(
            Pizza(id = 0, image = R.raw.ima_33, name = "Супермясной додстер", about = "Горячая закуска с цыпленком, моцареллой, митболами, острыми колбасками чоризо и соусом бургер в тонкой пшеничной лепешке",
                price = 28, category = Constants.ZAKUSKI, things = 1, size = 2))

        list.add(
            Pizza(id = 0, image = R.raw.img_32, name = "Додстер", about = "Легендарная горячая закуска с цыплёнком, томатами, моцареллой, соусом ранч в тонкой пшеничной лепешке",
                price = 25, category = Constants.ZAKUSKI, things = 1, size = 2)
        )

        list.add(
            Pizza(id = 31, image = R.raw.img_33 , name = "Острый Додстер", about = "Горячая закуска с цыплёнком, перцем халапенью, солеными огурчиками, томатами, моцареллой, и соусом барбекю в тонкой пшеничной лепешке",
                price = 25, category = Constants.ZAKUSKI, things = 1, size = 2)
        )

        list.add(
            Pizza(id = 32, image = R.raw.img_34 , name = "Рулетики с сыром", about = "Сытные рулетики с моцареллой и сырным соусом",
                price = 27, category = Constants.ZAKUSKI, things = 1, size = 2)
        )

        list.add(
            Pizza(id = 33, image = R.raw.img_35 , name = "Рулетики с пепперони, 16 шт.", about = "Горячие рулетики с колбасками пепперони, моцареллой и сырнымм соусом",
                price = 27, category = Constants.ZAKUSKI, things = 16, size = 2)
        )

        list.add(
            Pizza(id = 34, image = R.raw.img_36, name = "Рулетики с пепперони + Рулетики с сыром, 16 шт.", about = "Микс горячих рулетиков с сырным соусом, 8 штук с пепперони и моцареллой, 8 штук с моцареллой",
                price = 27, category = Constants.ZAKUSKI, things = 16, size = 2)
        )

        list.add(
            Pizza(id = 35, image = R.raw.img_37 , name = "Картофель из печи", about = "Ароматный запеченный картофель с итальянскими травами",
                price = 28, category = Constants.ZAKUSKI, things = 1, size = 2)
        )

        list.add(
            Pizza(id = 36, image = R.raw.img_38, name = "Стартер Грибной", about = "Горячая закуска с шампиньонами, моцареллой и соусом ранч в тонкой пшеничной лепешке",
                price = 25, category = Constants.ZAKUSKI, things = 1, size = 2)
        )

        list.add(
            Pizza(id = 37, image = R.raw.img_39, name = "Мясной Стартер", about = "Горячая закуска с митболами из говядины, томатами, моцареллой, и пикатным соусом бурегер в тонкой пшеничной лепешке",
                price = 25, category = Constants.ZAKUSKI, things = 1, size = 2)
        )

        list.add(
            Pizza(id = 38, image = R.raw.img_40, name = "Сырныр стартер", about = "Гораячая закуска с очень сырной начинкой. Моцарелла, пармезан, чеддери соус в тонкой пшеничной лепешке",
                price = 25, category = Constants.ZAKUSKI, things = 1, size = 2)
        )

        list.add(
            Pizza(id = 39, image = R.raw.img_41, name = "Куриные кусочки", about = "Кусочки куриного филе в хрустящей панировке",
                price = 48, category = Constants.ZAKUSKI, size = 2)
        )

        list.add(
            Pizza(id = 40, image = R.raw.img_42, name = "Салаь Греческой с соусом бальзамик", about = "Салат айсберг, томаты черри, маслины, свежий огурец, кубики брынзы, соус бальзамик",
                price = 27, category = Constants.ZAKUSKI, things = 1,size = 2)
        )

        list.add(
            Pizza(id = 41, image = R.raw.img_43, name = "Салат Цезарь", about = "Цыплёнок, свежие листья салата айсберг, томаты черри, сыры чеддер и пармезан, соус цезарь, пшеничные гренки, итальяские травы",
                price = 28, category = Constants.ZAKUSKI, size = 2)
        )

        list.add(
            Pizza(id = 42, image = R.raw.img_44, name = "Рулетки с корицей", about = "Сытные сладкие рулетки с корицей",
                price= 22, category = Constants.DESERTI,16, size = 2)
        )

        list.add(
            Pizza(id = 43, image = R.raw.img_45, name = "Чизкейк Нюь-Йорк", about = "Классические американские творожный десерт",
                price = 23, category = Constants.DESERTI, size = 2)
        )

        list.add(
            Pizza(id = 44, image = R.raw.img_46, name = "Маффин Три шоколада", about = "Десерт из натурального какао, нежной начинки на основе шоколада и кубиков белого и молочного шоколада",
                price = 12, category = Constants.DESERTI,size = 2 )
        )

        list.add(
            Pizza(id = 45, image = R.raw.img_47, name = "Кукис Три шоколада", about = "Большое нежное печенье с кусочками бельгийского молочного, тёмного и белого шоколада",
                price= 11, category = Constants.DESERTI,size = 2 )
        )

        list.add(
            Pizza(id = 0, image = R.raw.ima1_49, name = "Coca-cola",
                price= 10, category = Constants.NAPITKI, things = 1, size = 1))
        list.add(
            Pizza(id = 0, image = R.raw.img_49, name = "Coca-cola",
                price = 8, category = Constants.NAPITKI, things = 1, size = 2))
        list.add(
            Pizza(id =0, image = R.raw.img2_49, name = "Coca-cola",
                price = 12, category = Constants.NAPITKI, things = 1, size=3))


        list.add(
            Pizza(id = 47, image = R.raw.img_48, name = "Coca-Cola Zero",
                price = 8, category = Constants.NAPITKI, size = 2) )


        list.add(
            Pizza(id = 0, image = R.raw.img_50, name = "Sprite",
                price = 8, category = Constants.NAPITKI, size =2,) )
 list.add(
            Pizza(id = 0, image = R.raw.img2_50, name = "Sprite",
              price = 12, category = Constants.NAPITKI, size =3, ) )


        list.add(
            Pizza(id = 0, image = R.raw.img_51, name = "Fanta",
                price = 8, category = Constants.NAPITKI, size= 2) )
list.add(
            Pizza(id = 0, image = R.raw.img2_51, name = "Fanta",
                price = 12, category = Constants.NAPITKI, size = 3) )


        list.add(
            Pizza(id = 0, image = R.raw.img_52, name = "Fusetea, 0,5л",
                price = 8, category = Constants.NAPITKI, size = 2 ))


        list.add(
            Pizza(id = 0, image = R.raw.img_53, name = "БонАква негаз",
                price = 5, category = Constants.NAPITKI, size =  2)
            )


        list.add(
            Pizza(id = 0, image = R.raw.img_54, name = "Сок Добрый 1л",
                price = 28, category = Constants.NAPITKI, size = 2) )


        list.add(
            Pizza(id = 0, image = R.raw.img_55, name = "Сырный соус",
                price = 5, category = Constants.SOUSI, size = 2)
        )

        list.add(
            Pizza(id = 54, image = R.raw.img_56, name = "Барбекю",
                price = 5, category = Constants.SOUSI, size = 2 )
        )

        list.add(
            Pizza(id = 55, image = R.raw.img_57, name = "Чесночный",
                price = 5, category = Constants.SOUSI, size = 2 )
        )

        list.add(
            Pizza(id = 56, image = R.raw.img_58, name = "Додо Раскарска",
                price = 2, category = Constants.DRUGIE, size = 2 )
        )

        list.add(
            Pizza(id = 57, image = R.raw.img_59, name = "Додо книги 1+2", about = "Набор из двух книг - \"Додо Книга 1\" и  \"Додо Книга 2\". Рассказываем об истории, ценностях и развитии компании ",
                price = 49, category = Constants.DRUGIE, things = 2, size = 2)
        )
        return list
    }
}