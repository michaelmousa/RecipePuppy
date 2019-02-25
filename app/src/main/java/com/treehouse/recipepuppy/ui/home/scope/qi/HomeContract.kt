package com.treehouse.recipepuppy.ui.home.scope.qi

import com.treehouse.recipepuppy.model.ArrResults


interface HomeContract{

    interface View {
        fun showResults(results: ArrResults)
        fun showError(message: String)
    }
    interface Presenter{
        fun getDishDetails(title: String)


    }
}

