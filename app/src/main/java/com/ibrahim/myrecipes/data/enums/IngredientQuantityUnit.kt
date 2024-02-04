package com.ibrahim.myrecipes.data.enums

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.ibrahim.myrecipes.R

enum class IngredientQuantityUnit(val resourceId: Int) {
    GRAM(R.string.ingredient_quantity_unit_gram),
    KILOGRAM(R.string.ingredient_quantity_unit_kilogram),
    LITER(R.string.ingredient_quantity_unit_liter),
    TEASPOON(R.string.ingredient_quantity_unit_teaspoon),
    TABLESPOON(R.string.ingredient_quantity_unit_tablespoon),
    CUP(R.string.ingredient_quantity_unit_cup),
    PIECE(R.string.ingredient_quantity_unit_piece),
    PINCH(R.string.ingredient_quantity_unit_pinch),
    DASH(R.string.ingredient_quantity_unit_dash),
    OUNCE(R.string.ingredient_quantity_unit_ounce),
    POUND(R.string.ingredient_quantity_unit_pound),
    GALLON(R.string.ingredient_quantity_unit_gallon),
    QUART(R.string.ingredient_quantity_unit_quart),
    PINT(R.string.ingredient_quantity_unit_pint);
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

@Composable
fun IngredientQuantityUnit.getLabel(): String {
    val context = LocalContext.current
    return context.getString(this.resourceId)
}