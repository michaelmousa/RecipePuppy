package com.treehouse.recipepuppy.ui.home.scope.Di.IngrScope

import com.treehouse.recipepuppy.di.AppComponent
import com.treehouse.recipepuppy.ui.home.scope.Di.ingredients.IngrSecondActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [IngrHomeModel::class])
@IngrHomeScope
interface IngrHomeComponent {
    fun inject(ingrSecondActivity: IngrSecondActivity)
}