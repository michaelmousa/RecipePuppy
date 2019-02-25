package com.treehouse.recipepuppy.ui.home.scope.Di.IngrScope

import com.treehouse.recipepuppy.model.DataDishName

interface IngrHomeContract {


    interface View {
        fun showResults(results: DataDishName)
        fun showError(message: String)

    }
    interface Presenter{
        fun getIngredientsDetails(ingredients:String)

    }
}