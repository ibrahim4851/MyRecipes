package com.ibrahim.myrecipes.data.di

import android.content.Context
import androidx.room.Room
import com.ibrahim.myrecipes.data.room.dao.RecipeDao
import com.ibrahim.myrecipes.data.room.database.RecipeDatabase
import com.ibrahim.myrecipes.data.room.repository.RecipeRepositoryImpl
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRecipeDatabase(@ApplicationContext context: Context) =
         Room.databaseBuilder(
            context,
            RecipeDatabase::class.java,
            "recipe_db"
        ).build()

    @Provides
    @Singleton
    fun provideRecipeRepository(recipeDao: RecipeDao): RecipeRepository =
        RecipeRepositoryImpl(dao = recipeDao)

    @Provides
    @Singleton
    fun provideRecipeDao(recipeDatabase: RecipeDatabase) = recipeDatabase.dao

}