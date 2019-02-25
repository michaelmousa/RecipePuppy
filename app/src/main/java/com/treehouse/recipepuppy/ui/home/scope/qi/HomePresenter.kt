package com.treehouse.recipepuppy.ui.home.scope.qi

import com.treehouse.recipepuppy.network.RecipeService
import java.net.SocketException
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter  (

    private val recipeService: RecipeService,
    private val view: HomeContract.View): HomeContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getDishDetails(title: String) {

        compositeDisposable.add(recipeService.getDishNameDetails()
            .subscribeOn(Schedulers.io())
           .map { it }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ view.showResults(it) },

                { failure ->
                    if (failure is SocketException) {
                        view.showError("Domain Error")
                    } else {
                        view.showError(failure?.message ?: "An unknown error happened")
                    }}))}}


