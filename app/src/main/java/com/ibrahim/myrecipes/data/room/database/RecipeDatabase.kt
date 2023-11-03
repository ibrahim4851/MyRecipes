package com.ibrahim.myrecipes.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ibrahim.myrecipes.data.converter.BigDecimalConverter
import com.ibrahim.myrecipes.data.converter.IngredientQuantityConverter
import com.ibrahim.myrecipes.data.room.dao.RecipeDao
import com.ibrahim.myrecipes.data.room.entity.IngredientEntity
import com.ibrahim.myrecipes.data.room.entity.RecipeEntity

@Database(entities = [RecipeEntity::class, IngredientEntity::class], version = 1)
@TypeConverters(BigDecimalConverter::class, IngredientQuantityConverter::class)
abstract class RecipeDatabase : RoomDatabase() {
    abstract val dao: RecipeDao
}