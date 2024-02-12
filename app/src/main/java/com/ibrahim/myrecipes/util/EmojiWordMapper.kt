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
    "Chili Pepper" to "🌶",
    "bell pepper" to "🫑",
    "corn" to "🌽",
    "carrot" to "🥕",
    "olive" to "🫒",
    "garlic" to "🧄",
    "onion" to "🧅",
    "mushroom" to "🫚",
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
    "honey" to "🍯",
    "milk" to "🥛",
    "tea" to "🍵",
    "sake" to "🍶",
    "ice" to "🧊",
    "salt" to "🧂"
)





fun appendEmojiIfAny(ingredientName: String): String {
    val normalizedIngredientName = ingredientName.lowercase()

    fun singularizePhrase(phrase: String): String {
        return phrase.split(" ").joinToString(" ") { word ->
            singularize(word)
        }
    }

    val singularizedIngredientName = singularizePhrase(normalizedIngredientName)
    emojiMapEnglish[normalizedIngredientName]?.let { emoji ->
        return "$ingredientName $emoji"
    } ?: emojiMapEnglish[singularizedIngredientName]?.let { emoji ->
        return "$ingredientName $emoji"
    }


    val words = singularizedIngredientName.split(" ")
    for (word in words) {
        val emoji = emojiMapEnglish[word]
        if (emoji != null) {
            return "$ingredientName $emoji"
        }
    }

    return ingredientName
}


fun singularize(word: String): String {
    return when {
        word.endsWith("ies", ignoreCase = true) && word.length > 3 -> word.dropLast(3) + "y"
        word.endsWith("s", ignoreCase = true) && word.length > 1 -> word.dropLast(1)
        else -> word
    }.lowercase()
}
