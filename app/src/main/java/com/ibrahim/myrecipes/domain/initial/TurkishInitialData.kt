package com.ibrahim.myrecipes.domain.initial

import com.ibrahim.myrecipes.data.enums.FoodCategory
import com.ibrahim.myrecipes.data.enums.IngredientQuantityUnit
import com.ibrahim.myrecipes.domain.model.Ingredient
import com.ibrahim.myrecipes.domain.model.Recipe

val turkishRecipes = listOf(
    Recipe(
        recipeId = 1L,
        recipeTitle = "Klasik Hamburger",
        recipeDescription = "Ev yapımı lezzetli bir hamburger tarifi.",
        recipeInstructions = listOf(
            "250g kıyma, tuz, karabiber ile karıştırılır.",
            "Köfteler şekillendirilir ve ızgarada pişirilir.",
            "Ekmeklerin içine köfte, marul, domates, cheddar konularak servis edilir."
        ),
        recipeTime = 30,
        recipeServings = 4,
        foodCategory = FoodCategory.BURGER,
        recipePhotoUri = "file:///android_asset/images/tr/klasik_hamburger.jpeg"
    ),
    Recipe(
        recipeId = 2L,
        recipeTitle = "Mercimek Çorbası",
        recipeDescription = "Geleneksel Türk mutfağının vazgeçilmez lezzetlerinden biri olan mercimek çorbası tarifi.",
        recipeInstructions = listOf(
            "1 bardak kırmızı mercimeği yıkayıp süzün.",
            "Soğan ve sarımsağı küçük küçük doğrayın.",
            "Tencerede soğan, sarımsak ve havucu zeytinyağında kavurun.",
            "Mercimek, su ve tüm baharatları ekleyip kaynamaya bırakın.",
            "Sebzeler yumuşayana kadar pişirin, sonra blenderdan geçirin.",
            "Tuz ve limon suyu ile tatlandırıp servis edin."
        ),
        recipeTime = 45,
        recipeServings = 4,
        foodCategory = FoodCategory.SOUP,
        recipePhotoUri = "file:///android_asset/images/tr/mercimek_corbasi.jpeg"
    ),
    Recipe(
        recipeId = 3L,
        recipeTitle = "Kıymalı Makarna",
        recipeDescription = "Lezzetli domates soslu ve kıymalı makarna tarifi.",
        recipeInstructions = listOf(
            "Makarnayı paketin üzerindeki talimatlara göre haşlayın.",
            "Bir tavada zeytinyağını ısıtın ve kıymayı kavurun.",
            "Soğanı ve sarımsağı ekleyip, soğanlar şeffaflaşana kadar kavurmaya devam edin.",
            "Domates sosu, tuz ve karabiberi ekleyin ve orta ateşte sos koyulaşana kadar pişirin.",
            "Haşlanmış makarnayı süzün ve kıymalı sos ile karıştırın.",
            "İsteğe bağlı olarak rendelenmiş peynir ile servis edin."
        ),
        recipeTime = 30,
        recipeServings = 4,
        foodCategory = FoodCategory.PASTA,
        recipePhotoUri = "file:///android_asset/images/tr/kiymali_makarna.jpeg"
    ),
    Recipe(
        recipeId = 4L,
        recipeTitle = "Bisküvi Pastası",
        recipeDescription = "Pişirme gerektirmeyen, kolay ve lezzetli bisküvi pastası tarifi.",
        recipeInstructions = listOf(
            "Sütü bir kaba alın ve bisküvileri hızlıca süte batırıp çıkarın.",
            "Bisküvileri bir tabağa dizin ve aralarına kakaolu karışım sürün.",
            "Kakaolu karışım için, kakao, şeker ve sütü bir tencerede karıştırarak koyulaşana kadar pişirin.",
            "Pişen kakaolu karışımı biraz soğutun ve ardından bisküvilerin üzerine sürün.",
            "Tüm bisküviler bitene kadar bu işlemi tekrarlayın ve en üste kakaolu karışım sürün.",
            "Bisküvi pastasını birkaç saat buzdolabında bekletin.",
            "Üzerini isteğe bağlı olarak kırılmış bisküvi, çikolata parçaları veya fındık ile süsleyin."
        ),
        recipeTime = 120,
        recipeServings = 8,
        foodCategory = FoodCategory.DESSERT,
        recipePhotoUri = "file:///android_asset/images/tr/biskuvi_pastasi.jpeg"
    ),
    Recipe(
        recipeId = 5L,
        recipeTitle = "Çoban Salatası",
        recipeDescription = "Yaz aylarının vazgeçilmezi, ferahlatıcı ve sağlıklı bir salata tarifi.",
        recipeInstructions = listOf(
            "Domatesleri, salatalıkları, yeşil biberleri ve soğanı küp küp doğrayın.",
            "Tüm doğranmış sebzeleri büyük bir salata kasesinde karıştırın.",
            "Üzerine ince kıyılmış maydanoz, zeytinyağı, limon suyu, tuz ve karabiber ekleyin.",
            "Tüm malzemeleri iyice karıştırın ve soğuk servis yapın."
        ),
        recipeTime = 15,
        recipeServings = 4,
        foodCategory = FoodCategory.SALAD,
        recipePhotoUri = "file:///android_asset/images/tr/coban_salatasi.jpeg"
    ),
    Recipe(
        recipeId = 6L,
        recipeTitle = "Ayvalık Tostu",
        recipeDescription = "Ayvalık'ın meşhur zengin içerikli tostu, sokak lezzetlerinin en sevilenlerinden.",
        recipeInstructions = listOf(
            "Sosis ve salamı ince dilimler halinde kesin.",
            "Domates ve turşuyu dilimleyin.",
            "Tost ekmeğinin bir yüzeyine önce kaşar peyniri, ardından sosis, salam, domates ve turşu dilimlerini yerleştirin.",
            "İsteğe bağlı olarak mayonez ve ketçap ekleyin.",
            "Diğer dilim ekmekle sandviçi kapatın ve tost makinesinde iyice kızarana kadar pişirin."
        ),
        recipeTime = 15,
        recipeServings = 1,
        foodCategory = FoodCategory.SANDWICH,
        recipePhotoUri = "file:///android_asset/images/tr/ayvalik_tostu.jpeg"
    ),
    Recipe(
        recipeId = 7L,
        recipeTitle = "Türk Kahvesi",
        recipeDescription = "Geleneksel Türk kahvesi nasıl yapılır? Evde kolayca hazırlayabileceğiniz adım adım tarif.",
        recipeInstructions = listOf(
            "Bir cezveye kişi başı iki çay kaşığı kahve ve isteğe bağlı şeker ekleyin.",
            "Her fincan için bir fincan soğuk su ekleyin.",
            "Cezveyi orta ateşte koyun ve kahvenin yavaşça ısınmasını sağlayın.",
            "Kahve yavaşça köpürmeye başladığında, köpüğün bir kısmını fincanlara paylaştırın.",
            "Kahveyi tekrar cezveye dökün ve bir kez daha köpürünceye kadar ısıtın.",
            "Kahveyi fincanlara dökün ve köpükle birlikte servis edin.",
            "Kahvenin dibindeki telvesi çökmeye bırakın ve sıcakken servis yapın."
        ),
        recipeTime = 10,
        recipeServings = 1,
        foodCategory = FoodCategory.BEVERAGE,
        recipePhotoUri = "file:///android_asset/images/tr/turk_kahvesi.jpeg"
    ),
    Recipe(
        recipeId = 8L,
        recipeTitle = "Kuru Fasulye",
        recipeDescription = "Türk mutfağının klasik lezzetlerinden kuru fasulye tarifi, bol domates ve et suyuyla.",
        recipeInstructions = listOf(
            "Fasulyeleri bir gece önceden suda bekletin.",
            "Fasulyeleri süzün ve tencereye alın, üzerini geçecek kadar su ekleyip yumuşayana kadar haşlayın.",
            "Bir başka tencerede ince doğranmış soğanı zeytinyağında pembeleşene kadar kavurun.",
            "Küp küp doğranmış domatesi ve biber salçasını ekleyip birkaç dakika daha kavurun.",
            "Haşlanmış fasulyeleri, kavrulmuş soğan ve domates karışımına ekleyin.",
            "Et suyunu ekleyip fasulyeler yumuşayana kadar kısık ateşte pişirin.",
            "Tuz, karabiber ve isteğe bağlı olarak pul biber ekleyin, birkaç dakika daha kaynatıp ocaktan alın.",
            "Sıcak olarak pilav veya bulgur pilavıyla servis yapın."
        ),
        recipeTime = 120,
        recipeServings = 6,
        foodCategory = FoodCategory.VEGETARIAN,
        recipePhotoUri = "file:///android_asset/images/tr/kuru_fasulye.jpeg"
    ),
    Recipe(
        recipeId = 9L,
        recipeTitle = "Tavada Hamsi",
        recipeDescription = "Karadeniz bölgesinin vazgeçilmez lezzeti, tavada çıtır çıtır hamsiler.",
        recipeInstructions = listOf(
            "Hamsileri temizleyin, kafalarını koparın ve iç organlarını çıkarın.",
            "Hamsileri bol su ile yıkayın ve suyunu süzün.",
            "Bir kase içerisinde un, tuz ve karabiberi karıştırın.",
            "Hamsileri bu karışıma bulayın ve fazla ununu silkeleyin.",
            "Tavayı orta ateşte ısıtın ve zeytinyağını ekleyin.",
            "Hamsileri tavaya dizin ve her iki tarafını da altın kahverengi olana kadar pişirin.",
            "Pişen hamsileri kağıt havlu üzerine alarak fazla yağını süzün.",
            "Limon dilimleri ile sıcak servis yapın."
        ),
        recipeTime = 20,
        recipeServings = 4,
        foodCategory = FoodCategory.SEAFOOD,
        recipePhotoUri = "file:///android_asset/images/tr/tavada_hamsi.jpeg"
    ),
    Recipe(
        recipeId = 10L,
        recipeTitle = "Kabak Yemeği",
        recipeDescription = "Sağlıklı ve lezzetli bir sebze yemeği, ana malzemesi olarak kabak kullanılarak hazırlanır.",
        recipeInstructions = listOf(
            "Kabakları yıkayın, uçlarını kesin ve isteğe bağlı olarak soyun. Ardından küp küp doğrayın.",
            "Soğanı yemeklik doğrayın ve zeytinyağında pembeleşene kadar kavurun.",
            "Doğranmış domates ve biberi ekleyin, birkaç dakika daha kavurun.",
            "Doğranmış kabakları, tuz ve karabiberi ekleyip karıştırın.",
            "Yeterince su ekleyip kabaklar yumuşayıncaya kadar kısık ateşte pişirin.",
            "Pişme süresinin son 10 dakikasında ince doğranmış dereotunu ekleyin.",
            "Sıcak olarak servis yapın, yanında yoğurt ile mükemmeldir."
        ),
        recipeTime = 40,
        recipeServings = 4,
        foodCategory = FoodCategory.VEGETABLE,
        recipePhotoUri = "file:///android_asset/images/tr/kabak_yemegi.jpeg"
    ),
    Recipe(
        recipeId = 11L,
        recipeTitle = "Tavuk Tantuni",
        recipeDescription = "Hafif baharatlı ve lezzetli tavuk tantuni tarifi, sokak lezzetlerinden ilham alınarak hazırlanmıştır.",
        recipeInstructions = listOf(
            "Tavuğu ince şeritler halinde kesin.",
            "Bir tavada zeytinyağı ısıtın ve tavuğu yüksek ateşte soteleyin.",
            "Tavuk suyunu salıp çekmeye başlayınca ince doğranmış soğan, biber, domates ve baharatları ekleyin.",
            "Malzemeleri hızlı bir şekilde karıştırarak 5-10 dakika daha pişirin.",
            "Lavaş ekmeğinin üzerine tantuniyi yerleştirin, üzerine ince doğranmış maydanoz, sumaklı soğan ve isteğe bağlı olarak limon suyu ekleyin.",
            "Lavaşı rulo yaparak sıkıca sarın ve isteğe bağlı olarak yanında ayran ile servis edin."
        ),
        recipeTime = 30,
        recipeServings = 4,
        foodCategory = FoodCategory.CHICKEN,
        recipePhotoUri = "file:///android_asset/images/tr/tavuk_tantuni.jpeg"
    ),
    Recipe(
        recipeId = 12L,
        recipeTitle = "Şiş Kebab",
        recipeDescription = "Marinasyonu ile etin lezzetini maksimuma çıkaran, mangalda pişirilen geleneksel Türk şiş kebabı tarifi.",
        recipeInstructions = listOf(
            "Etleri kuşbaşı büyüklüğünde kesin.",
            "Bir kasede zeytinyağı, rendelenmiş soğan, ezilmiş sarımsak, tuz, karabiber, kekik ve pul biberi karıştırarak marinad hazırlayın.",
            "Etleri bu marinada en az 4 saat, tercihen bir gece bekletin.",
            "Marinadan çıkarılan etleri şişlere dizin.",
            "Şişleri önceden ısıtılmış ızgarada her tarafı eşit pişene kadar döndürerek pişirin.",
            "Pişen kebapları sıcak servis yapın, yanında arzuya göre pilav, lavaş ekmeği ve çeşitli meze ile sunabilirsiniz."
        ),
        recipeTime = 45,
        recipeServings = 4,
        foodCategory = FoodCategory.BBQ,
        recipePhotoUri = "file:///android_asset/images/tr/sis_kebab.jpeg"
    ),
    Recipe(
        recipeId = 13L,
        recipeTitle = "Tavada Pirzola",
        recipeDescription = "Baharatlarla marine edilmiş, tavada kızartılarak hazırlanan lezzetli ve yumuşacık bir pirzola tarifi.",
        recipeInstructions = listOf(
            "Pirzolaları zeytinyağı, tuz, karabiber, kekik ve sarımsak ile marine edin ve en az 30 dakika bekletin.",
            "Bir tavayı orta-yüksek ateşte ısıtın ve pirzolaları ekleyin.",
            "Her bir tarafını 3-4 dakika pişirin veya istediğiniz pişirme derecesine ulaşana kadar pişirin.",
            "Pişirme işlemi bittikten sonra pirzolaları tavada birkaç dakika dinlendirin.",
            "Tercihen taze kekik yaprakları ve limon dilimleri ile sıcak servis yapın."
        ),
        recipeTime = 20,
        recipeServings = 4,
        foodCategory = FoodCategory.STEAK,
        recipePhotoUri = "file:///android_asset/images/tr/tavada_pirzola.jpeg"
    )
)


val turkishRecipesIngredients = listOf(
    Ingredient(
        ingredientId = 1L,
        ownerRecipeId = 1L,
        ingredientName = "Kıyma",
        ingredientQuantity = 150.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 2L,
        ownerRecipeId = 1L,
        ingredientName = "Tuz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PINCH //it's TUTAM in turkish
    ),
    Ingredient(
        ingredientId = 3L,
        ownerRecipeId = 1L,
        ingredientName = "Karabiber",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PINCH //it's TUTAM in turkish
    ),
    Ingredient(
        ingredientId = 4L,
        ownerRecipeId = 1L,
        ingredientName = "Cheddar Peyniri",
        ingredientQuantity = 4.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.SLICE
    ),
    Ingredient(
        ingredientId = 5L,
        ownerRecipeId = 1L,
        ingredientName = "Domates",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 6L,
        ownerRecipeId = 2L,
        ingredientName = "Kırmızı Mercimek",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.CUP
    ),
    Ingredient(
        ingredientId = 7L,
        ownerRecipeId = 2L,
        ingredientName = "Soğan",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 8L,
        ownerRecipeId = 2L,
        ingredientName = "Sarımsak",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 9L,
        ownerRecipeId = 2L,
        ingredientName = "Havuç",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 10L,
        ownerRecipeId = 2L,
        ingredientName = "Zeytinyağı",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 11L,
        ownerRecipeId = 2L,
        ingredientName = "Su",
        ingredientQuantity = 4.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.LITER
    ),
    Ingredient(
        ingredientId = 12L,
        ownerRecipeId = 2L,
        ingredientName = "Tuz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 13L,
        ownerRecipeId = 2L,
        ingredientName = "Karabiber",
        ingredientQuantity = 0.5.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 14L,
        ownerRecipeId = 2L,
        ingredientName = "Limon Suyu",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 15L,
        ownerRecipeId = 3L,
        ingredientName = "Makarna",
        ingredientQuantity = 500.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 16L,
        ownerRecipeId = 3L,
        ingredientName = "Zeytinyağı",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 17L,
        ownerRecipeId = 3L,
        ingredientName = "Kıyma",
        ingredientQuantity = 250.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 18L,
        ownerRecipeId = 3L,
        ingredientName = "Soğan",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 19L,
        ownerRecipeId = 3L,
        ingredientName = "Sarımsak",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 20L,
        ownerRecipeId = 3L,
        ingredientName = "Domates Sosu",
        ingredientQuantity = 200.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 21L,
        ownerRecipeId = 3L,
        ingredientName = "Tuz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 22L,
        ownerRecipeId = 3L,
        ingredientName = "Karabiber",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 23L,
        ownerRecipeId = 4L,
        ingredientName = "Petit Beurre Bisküvi",
        ingredientQuantity = 300.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 24L,
        ownerRecipeId = 4L,
        ingredientName = "Süt (bisküvileri ıslatmak için)",
        ingredientQuantity = 500.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.MILLILITER
    ),
    Ingredient(
        ingredientId = 25L,
        ownerRecipeId = 4L,
        ingredientName = "Kakao",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 26L,
        ownerRecipeId = 4L,
        ingredientName = "Şeker",
        ingredientQuantity = 100.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 27L,
        ownerRecipeId = 4L,
        ingredientName = "Süt (kakaolu karışım için)",
        ingredientQuantity = 200.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.MILLILITER
    ),
    Ingredient(
        ingredientId = 28L,
        ownerRecipeId = 5L,
        ingredientName = "Domates",
        ingredientQuantity = 3.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 29L,
        ownerRecipeId = 5L,
        ingredientName = "Salatalık",
        ingredientQuantity = 3.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 30L,
        ownerRecipeId = 5L,
        ingredientName = "Yeşil Biber",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 31L,
        ownerRecipeId = 5L,
        ingredientName = "Soğan",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 32L,
        ownerRecipeId = 5L,
        ingredientName = "Maydanoz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PINCH
    ),
    Ingredient(
        ingredientId = 33L,
        ownerRecipeId = 5L,
        ingredientName = "Zeytinyağı",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 34L,
        ownerRecipeId = 5L,
        ingredientName = "Limon Suyu",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 35L,
        ownerRecipeId = 5L,
        ingredientName = "Tuz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 36L,
        ownerRecipeId = 5L,
        ingredientName = "Karabiber",
        ingredientQuantity = 0.5.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 37L,
        ownerRecipeId = 6L,
        ingredientName = "Tost Ekmeği",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 38L,
        ownerRecipeId = 6L,
        ingredientName = "Kaşar Peyniri",
        ingredientQuantity = 4.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.SLICE
    ),
    Ingredient(
        ingredientId = 39L,
        ownerRecipeId = 6L,
        ingredientName = "Sosis",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 40L,
        ownerRecipeId = 6L,
        ingredientName = "Salam",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 41L,
        ownerRecipeId = 6L,
        ingredientName = "Domates",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 42L,
        ownerRecipeId = 6L,
        ingredientName = "Turşu",
        ingredientQuantity = 4.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 43L,
        ownerRecipeId = 7L,
        ingredientName = "Türk Kahvesi (İnce Öğütülmüş)",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 44L,
        ownerRecipeId = 7L,
        ingredientName = "Su",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.CUP
    ),
    Ingredient(
        ingredientId = 45L,
        ownerRecipeId = 7L,
        ingredientName = "Şeker (isteğe bağlı)",
        ingredientQuantity = 1.toBigDecimal(), // Adjust based on sweetness preference: no sugar (sade), a little sugar (az şekerli), medium sugar (orta), or sweet (şekerli).
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 46L,
        ownerRecipeId = 8L,
        ingredientName = "Kuru Fasulye",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.CUP
    ),
    Ingredient(
        ingredientId = 47L,
        ownerRecipeId = 8L,
        ingredientName = "Su (fasulyeyi haşlamak için)",
        ingredientQuantity = 8.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.CUP // Adjust as needed based on the soaking and cooking process
    ),
    Ingredient(
        ingredientId = 48L,
        ownerRecipeId = 8L,
        ingredientName = "Soğan",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 49L,
        ownerRecipeId = 8L,
        ingredientName = "Zeytinyağı",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 50L,
        ownerRecipeId = 8L,
        ingredientName = "Domates",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 51L,
        ownerRecipeId = 8L,
        ingredientName = "Biber Salçası",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 52L,
        ownerRecipeId = 8L,
        ingredientName = "Et Suyu",
        ingredientQuantity = 4.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.CUP
    ),
    Ingredient(
        ingredientId = 53L,
        ownerRecipeId = 8L,
        ingredientName = "Tuz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 54L,
        ownerRecipeId = 8L,
        ingredientName = "Karabiber",
        ingredientQuantity = 0.5.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 55L,
        ownerRecipeId = 9L,
        ingredientName = "Hamsi",
        ingredientQuantity = 500.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 56L,
        ownerRecipeId = 9L,
        ingredientName = "Un",
        ingredientQuantity = 100.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 57L,
        ownerRecipeId = 9L,
        ingredientName = "Tuz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 58L,
        ownerRecipeId = 9L,
        ingredientName = "Karabiber",
        ingredientQuantity = 0.5.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 59L,
        ownerRecipeId = 9L,
        ingredientName = "Zeytinyağı",
        ingredientQuantity = 4.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 60L,
        ownerRecipeId = 9L,
        ingredientName = "Limon",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 61L,
        ownerRecipeId = 10L,
        ingredientName = "Kabak",
        ingredientQuantity = 500.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 62L,
        ownerRecipeId = 10L,
        ingredientName = "Soğan",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 63L,
        ownerRecipeId = 10L,
        ingredientName = "Domates",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 64L,
        ownerRecipeId = 10L,
        ingredientName = "Yeşil Biber",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 65L,
        ownerRecipeId = 10L,
        ingredientName = "Zeytinyağı",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 66L,
        ownerRecipeId = 10L,
        ingredientName = "Tuz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 67L,
        ownerRecipeId = 10L,
        ingredientName = "Karabiber",
        ingredientQuantity = 0.5.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 68L,
        ownerRecipeId = 10L,
        ingredientName = "Dereotu",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PINCH
    ),
    Ingredient(
        ingredientId = 70L,
        ownerRecipeId = 11L,
        ingredientName = "Tavuk Göğsü",
        ingredientQuantity = 500.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 71L,
        ownerRecipeId = 11L,
        ingredientName = "Zeytinyağı",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 72L,
        ownerRecipeId = 11L,
        ingredientName = "Soğan",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 73L,
        ownerRecipeId = 11L,
        ingredientName = "Yeşil Biber",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 74L,
        ownerRecipeId = 11L,
        ingredientName = "Domates",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 75L,
        ownerRecipeId = 11L,
        ingredientName = "Pul Biber",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 76L,
        ownerRecipeId = 11L,
        ingredientName = "Karabiber",
        ingredientQuantity = 0.5.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 77L,
        ownerRecipeId = 11L,
        ingredientName = "Tuz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 78L,
        ownerRecipeId = 11L,
        ingredientName = "Lavaş Ekmeği",
        ingredientQuantity = 4.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 79L,
        ownerRecipeId = 11L,
        ingredientName = "Maydanoz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PINCH
    ),
    Ingredient(
        ingredientId = 81L,
        ownerRecipeId = 12L,
        ingredientName = "Kuşbaşı Et (dana veya kuzu)",
        ingredientQuantity = 500.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.GRAM
    ),
    Ingredient(
        ingredientId = 82L,
        ownerRecipeId = 12L,
        ingredientName = "Zeytinyağı",
        ingredientQuantity = 4.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 83L,
        ownerRecipeId = 12L,
        ingredientName = "Soğan",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 84L,
        ownerRecipeId = 12L,
        ingredientName = "Sarımsak",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 85L,
        ownerRecipeId = 12L,
        ingredientName = "Tuz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 86L,
        ownerRecipeId = 12L,
        ingredientName = "Karabiber",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 87L,
        ownerRecipeId = 12L,
        ingredientName = "Kekik",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 88L,
        ownerRecipeId = 12L,
        ingredientName = "Pul Biber",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 89L,
        ownerRecipeId = 13L,
        ingredientName = "Kuzu Pirzola",
        ingredientQuantity = 8.toBigDecimal(), // Assuming 2 pirzolas per serving
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
    Ingredient(
        ingredientId = 90L,
        ownerRecipeId = 13L,
        ingredientName = "Zeytinyağı",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TABLESPOON
    ),
    Ingredient(
        ingredientId = 91L,
        ownerRecipeId = 13L,
        ingredientName = "Tuz",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 92L,
        ownerRecipeId = 13L,
        ingredientName = "Karabiber",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 93L,
        ownerRecipeId = 13L,
        ingredientName = "Kekik",
        ingredientQuantity = 1.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.TEASPOON
    ),
    Ingredient(
        ingredientId = 94L,
        ownerRecipeId = 13L,
        ingredientName = "Sarımsak",
        ingredientQuantity = 2.toBigDecimal(),
        ingredientQuantityUnit = IngredientQuantityUnit.PIECE
    ),
)