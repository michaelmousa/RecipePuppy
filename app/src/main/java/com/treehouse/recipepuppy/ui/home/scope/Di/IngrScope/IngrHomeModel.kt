package com.treehouse.recipepuppy.ui.home.scope.Di.IngrScope

import com.treehouse.recipepuppy.network.RecipeService
import com.treehouse.recipepuppy.ui.home.scope.Di.ingredients.IngrHomePersenter
import dagger.Module
import dagger.Provides

@Module
class IngrHomeModel(private val view: IngrHomeContract.View) {


    @IngrHomeScope
    @Provides
    fun provideIngrHomePresenter(recipeService: RecipeService)
            : IngrHomeContract.Presenter {
        return IngrHomePersenter(recipeService, view)
    }
}