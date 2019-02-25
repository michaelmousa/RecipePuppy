package com.treehouse.recipepuppy.ui.home.scope.Di.ingredients

import com.treehouse.recipepuppy.network.RecipeService
import com.treehouse.recipepuppy.ui.home.scope.Di.IngrScope.IngrHomeContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class IngrHomePersenter(
    private val recipeService: RecipeService,
    private val view: IngrHomeContract.View
) : IngrHomeContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getIngredientsDetails(ingredients:String) {

        compositeDisposable.add(recipeService.getIngredientsDetails(ingredients)
                .map{it}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view.showResults(it) },
                    { failure -> view.showError(failure?.message ?: "An unknown error happened") })
        )
    }
}