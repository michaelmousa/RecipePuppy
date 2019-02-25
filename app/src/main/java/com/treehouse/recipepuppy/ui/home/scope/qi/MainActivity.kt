package com.treehouse.recipepuppy.ui.home.scope.qi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewDebug
import android.widget.Toast
import com.treehouse.recipepuppy.App
import com.treehouse.recipepuppy.R
import com.treehouse.recipepuppy.model.ArrResults
import com.treehouse.recipepuppy.ui.home.scope.qi.DishScope.HomeModule
import com.treehouse.recipepuppy.ui.home.scope.Di.ingredients.IngrSecondActivity
import com.treehouse.recipepuppy.ui.home.scope.qi.DishScope.DaggerHomeComponent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.second_activity.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View{


    @Inject
    lateinit var homePresenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)


        btnDishName.setOnClickListener{ homePresenter.getDishDetails(edDishName.text.toString())}

        btnShowIngredients.setOnClickListener {
            startActivity(Intent(this, IngrSecondActivity::class.java))
        }
}
    override fun showResults(results: ArrResults) {
        tvDishName.text= results.title

    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()    }
}