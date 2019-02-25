package com.treehouse.recipepuppy.ui.home.scope.qi.DishScope

import com.treehouse.recipepuppy.ui.home.scope.qi.HomePresenter
import com.treehouse.recipepuppy.network.RecipeService
import com.treehouse.recipepuppy.ui.home.scope.qi.HomeContract
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val view: HomeContract.View) {


    @HomeScope
    @Provides
    fun provideHomePresenter(recipeService: RecipeService)
            : HomeContract.Presenter {
        return HomePresenter(recipeService, view)
    }
}