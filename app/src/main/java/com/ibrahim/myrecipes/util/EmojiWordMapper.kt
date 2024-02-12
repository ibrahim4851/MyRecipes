package com.ibrahim.myrecipes.util

val emojiMapEnglish = mapOf(
    "apple" to "🍎",
    "pear" to "🍐",
    "orange" to "🍊",
    "lemon" to "🍋",
    "banana" to "🍌",
    "watermelon" to "🍉",
    "grapes" to "🍇",
    "strawberry" to "🍓",
    "blueberries" to "🫐",
    "melon" to "🍈",
    "cherries" to "🍒",
    "peach" to "🍑",
    "mango" to "🥭",
    "pineapple" to "🍍",
    "coconut" to "🥥",
    "kiwi" to "🥝",
    "tomato" to "🍅",
    "eggplant" to "🍆",
    "avocado" to "🥑",
    "broccoli" to "🥦",
    "peas" to "🫛",
    "lettuce" to "🥬",
    "cucumber" to "🥒",
    "chili pepper" to "🌶",
    "bell pepper" to "🫑",
    "corn" to "🌽",
    "carrot" to "🥕",
    "olive" to "🫒",
    "garlic" to "🧄",
    "onion" to "🧅",
    "mushroom" to "\uD83C\uDF44",
    "potato" to "🥔",
    "Sweet Potato" to "🍠",
    "beans" to "🫘",
    "bagel" to "🥯",
    "bread" to "🍞",
    "baguette" to "🥖",
    "cheese" to "🧀",
    "egg" to "🥚",
    "butter" to "🧈",
    "bacon" to "🥓",
    "meat" to "🥩",
    "ground beef" to "🥩",
    "steak" to "🥩",
    "parsley" to "\uD83C\uDF3F",
    "thyme" to "\uD83C\uDF3F",
    "basil" to "\uD83C\uDF31",
    "mustard" to "⚱\uFE0F",
    "tortilla" to "🫓",
    "canned" to "🥫",
    "ramen" to "🍜",
    "shrimp" to "🍤",
    "rice" to "🍚",
    "Ice Cream" to "🍨",
    "chocolate" to "🍫",
    "popcorn" to "🍿",
    "chestnut" to "🌰",
    "peanuts" to "🥜",
    "nuts" to "🥜",
    "honey" to "🍯",
    "milk" to "🥛",
    "tea" to "🍵",
    "sake" to "🍶",
    "ice" to "🧊",
    "salt" to "🧂"
)


val emojiMapTurkish = mapOf(
    "elma" to "🍎",
    "armut" to "🍐",
    "portakal" to "🍊",
    "limon" to "🍋",
    "muz" to "🍌",
    "karpuz" to "🍉",
    "üzüm" to "🍇",
    "çilek" to "🍓",
    "yaban mersini" to "🫐",
    "kavun" to "🍈",
    "kiraz" to "🍒",
    "şeftali" to "🍑",
    "mango" to "🥭",
    "ananas" to "🍍",
    "hindistan ceviz" to "🥥",
    "kivi" to "🥝",
    "domates" to "🍅",
    "patlıcan" to "🍆",
    "avokado" to "🥑",
    "brokoli" to "🥦",
    "bezelye" to "🫛",
    "marul" to "🥬",
    "salatalık" to "🥒",
    "acı biber" to "🌶",
    "dolmalık biber" to "🫑",
    "yeşil biber" to "🫑",
    "mısır" to "🌽",
    "havuç" to "🥕",
    "zeytin" to "🫒",
    "sarımsak" to "🧄",
    "soğan" to "🧅",
    "mantar" to "\uD83C\uDF44",
    "patates" to "🥔",
    "Tatlı Patates" to "🍠",
    "fasulye" to "🫘",
    "simit" to "🥯",
    "ekmek" to "🍞",
    "baget" to "🥖",
    "peynir" to "🧀",
    "yumurta" to "🥚",
    "tereyağı" to "🧈",
    "pastırma" to "🥓",
    "et" to "🥩",
    "kıyma" to "🥩",
    "biftek" to "🥩",
    "maydanoz" to "\uD83C\uDF3F",
    "kekik" to "\uD83C\uDF3F",
    "fesleğen" to "\uD83C\uDF31",
    "hardal" to "⚱\uFE0F",
    "tortilla" to "🫓",
    "konserve" to "🥫",
    "ramen" to "🍜",
    "karides" to "🍤",
    "pirinç" to "🍚",
    "Dondurma" to "🍨",
    "çikolata" to "🍫",
    "patlamış mısır" to "🍿",
    "kestane" to "🌰",
    "yer fıstığı" to "🥜",
    "fındık" to "🥜",
    "bal" to "🍯",
    "süt" to "🥛",
    "çay" to "🍵",
    "buz" to "🧊",
    "tuz" to "🧂"
)



fun appendEmojiIfAny(ingredientName: String, emojiMap: Map<String, String>, isTurkish: Boolean): String {
    val normalizedIngredientName = ingredientName.lowercase()
    val processedIngredientName = if (isTurkish) {
        removeTurkishSuffixes(normalizedIngredientName)
    } else {
        singularize(normalizedIngredientName)
    }
    emojiMap[processedIngredientName]?.let { emoji ->
        return "$ingredientName $emoji"
    }
    val words = processedIngredientName.split(" ")
    for (word in words) {
        emojiMap[word]?.let { emoji ->
            return "$ingredientName $emoji"
        }
    }
    return ingredientName
}



fun singularize(word: String): String {
    return when {
        word.endsWith("ies", ignoreCase = true) && word.length > 3 -> word.dropLast(3) + "y"
        word.endsWith("es", ignoreCase = true) && (word.endsWith("oes") || word.endsWith("ses") || word.endsWith("ches")) && word.length > 2 -> word.dropLast(2) // Corrected to handle cases like "Tomatoes", "Buses", "Matches"
        word.endsWith("s", ignoreCase = true) && word.length > 1 && !word.endsWith("us") && !word.endsWith("ss") -> word.dropLast(1) // Avoids incorrect singularization of words ending in "us" (as in "Virus" to "Viru") and "ss" (as in "Class" to "Clas")
        else -> word
    }.lowercase()
}


fun removeTurkishSuffixes(word: String): String {
    val suffixRegex = Regex("([ıiüu]s?[ıiüu]?)$")
    return word.split(" ").joinToString(" ") { singleWord ->
        suffixRegex.replace(singleWord.lowercase(), "")
    }
}
