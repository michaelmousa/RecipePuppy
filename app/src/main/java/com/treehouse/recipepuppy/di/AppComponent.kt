package com.treehouse.recipepuppy.di

import com.treehouse.recipepuppy.network.RecipeService
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent{
    fun recipeService(): RecipeService
}