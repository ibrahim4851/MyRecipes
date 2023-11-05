package com.ibrahim.myrecipes.data.enums

enum class IngredientQuantityUnit(val value: String) {
    GRAM("Gr"),
    KILOGRAM("Kg"),
    LITER("Lt"),
    TEASPOON("Tspn"),
    TABLESPOON("Tblspn"),
    CUP("Cup"),
    PIECE("Piece"),
    PINCH("Pinch"),
    DASH("Dash"),
    OUNCE("Ounce"),
    POUND("Pound"),
    GALLON("Gallon"),
    QUART("Quart"),
    PINT("Pint")
}

fun getAllIngredientQuantityUnits(): List<IngredientQuantityUnit> {
    return listOf(
        IngredientQuantityUnit.GRAM,
        IngredientQuantityUnit.KILOGRAM,
        IngredientQuantityUnit.LITER,
        IngredientQuantityUnit.TEASPOON,
        IngredientQuantityUnit.TABLESPOON,
        IngredientQuantityUnit.CUP,
        IngredientQuantityUnit.PIECE,
        IngredientQuantityUnit.PINCH,
        IngredientQuantityUnit.DASH,
        IngredientQuantityUnit.OUNCE,
        IngredientQuantityUnit.POUND,
        IngredientQuantityUnit.GALLON,
        IngredientQuantityUnit.QUART,
        IngredientQuantityUnit.PINT
    )
}

fun getIngredientQuantityUnit(value: String): IngredientQuantityUnit? {
    val map = IngredientQuantityUnit.values().associateBy(IngredientQuantityUnit::value)
    return map[value]
}
