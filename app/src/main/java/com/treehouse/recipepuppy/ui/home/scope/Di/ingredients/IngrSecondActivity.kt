package com.treehouse.recipepuppy.ui.home.scope.Di.ingredients

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.treehouse.recipepuppy.App
import com.treehouse.recipepuppy.R
import com.treehouse.recipepuppy.model.DataDishName
import com.treehouse.recipepuppy.ui.home.scope.Di.IngrScope.DaggerIngrHomeComponent
import com.treehouse.recipepuppy.ui.home.scope.Di.IngrScope.IngrHomeContract
import com.treehouse.recipepuppy.ui.home.scope.Di.IngrScope.IngrHomeModel
import kotlinx.android.synthetic.main.second_activity.*
import javax.inject.Inject

class IngrSecondActivity : AppCompatActivity(), IngrHomeContract.View {

    private val recipeAdapter = RecipeAdapter()
    @Inject
    lateinit var ingrHomePresenter: IngrHomeContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        DaggerIngrHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .ingrHomeModel(IngrHomeModel(this))
            .build()
            .inject(this)

        val layoutManager = LinearLayoutManager(this)

        rvResults.layoutManager = layoutManager
        rvResults.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        rvResults.adapter = recipeAdapter

        btnIngredients.setOnClickListener {
            ingrHomePresenter.getIngredientsDetails(edIngredients.text.toString())

        } }
    override fun showResults(results: DataDishName) {
        recipeAdapter.setData(results)    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()    }

}