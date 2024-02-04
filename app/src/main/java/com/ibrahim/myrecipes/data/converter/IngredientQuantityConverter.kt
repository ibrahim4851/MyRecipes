package com.ibrahim.myrecipes.data.converter

import androidx.room.TypeConverter
import com.ibrahim.myrecipes.data.enums.IngredientQuantityUnit

object IngredientQuantityConverter {

    @TypeConverter
    fun fromIngredientQuantityUnit(ingredientQuantityUnit: IngredientQuantityUnit): String {
        return ingredientQuantityUnit.name
    }

    @TypeConverter
    fun toIngredientQuantityUnit(name: String): IngredientQuantityUnit {
        return IngredientQuantityUnit.valueOf(name)
    }

}