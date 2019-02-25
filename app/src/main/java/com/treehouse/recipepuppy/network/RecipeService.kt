package com.treehouse.recipepuppy.network

import com.treehouse.recipepuppy.model.ArrResults
import com.treehouse.recipepuppy.model.DataDishName
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {

    @GET(ENDPOINT)
    fun getDishNameDetails(): Observable<ArrResults>

    @GET(ENDPOINT)
    fun getIngredientsDetails(@Query("ingredients")ingredients:String):Observable<DataDishName>
}