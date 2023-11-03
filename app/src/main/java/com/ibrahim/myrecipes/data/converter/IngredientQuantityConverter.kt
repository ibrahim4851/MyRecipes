package com.ibrahim.myrecipes.data.converter

import androidx.room.TypeConverter
import com.ibrahim.myrecipes.data.enums.IngredientQuantityUnit
import com.ibrahim.myrecipes.data.enums.getIngredientQuantityUnit

object IngredientQuantityConverter {

    @TypeConverter
    fun fromIngredientQuantityUnit(ingredientQuantityUnit: IngredientQuantityUnit): String {
        return ingredientQuantityUnit.value
    }

    @TypeConverter
    fun toIngredientQuantityUnit(ingredientQuantityUnit: String): IngredientQuantityUnit {
        return getIngredientQuantityUnit(ingredientQuantityUnit)!!
    }

}