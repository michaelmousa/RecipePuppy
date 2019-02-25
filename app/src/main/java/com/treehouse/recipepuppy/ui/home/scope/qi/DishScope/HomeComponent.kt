package com.treehouse.recipepuppy.ui.home.scope.qi.DishScope

import com.treehouse.recipepuppy.ui.home.scope.qi.MainActivity
import com.treehouse.recipepuppy.di.AppComponent
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun inject(mainActivity: MainActivity)
}