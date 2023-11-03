package com.ibrahim.myrecipes.data.di

import android.app.Application
import androidx.room.Room
import com.ibrahim.myrecipes.data.room.database.RecipeDatabase
import com.ibrahim.myrecipes.data.room.repository.RecipeRepositoryImpl
import com.ibrahim.myrecipes.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRecipeDatabase(app: Application): RecipeDatabase {
        return Room.databaseBuilder(
            app,
            RecipeDatabase::class.java,
            "recipe_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(
        db: RecipeDatabase): RecipeRepository {
        return RecipeRepositoryImpl(dao = db.dao)
    }

}