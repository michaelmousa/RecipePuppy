package com.treehouse.recipepuppy.ui.home.scope.Di.ingredients

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.treehouse.recipepuppy.R
import com.treehouse.recipepuppy.model.DataDishName

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RanViewHolder>() {


    private val data = arrayListOf<DataDishName>()

    fun setData(data: DataDishName) {
        this.data.clear()
        this.data.addAll(listOf(data))
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RanViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_pass, parent, false)
        return RanViewHolder(rootView)
    }
    override fun getItemCount(): Int { return data.size }

    override fun onBindViewHolder(viewHolder: RanViewHolder, position: Int)
    { viewHolder.bind(data[position]) }

    class RanViewHolder(private val rootView: View) : RecyclerView.ViewHolder(rootView) {

        fun bind(data: DataDishName) {

            val tvDishNamee =rootView.findViewById<TextView>(R.id.tvDishNamee)
            tvDishNamee.text= data.title

          val tvIngredients =rootView.findViewById<TextView>(R.id.tvIngredients)
            tvIngredients.text= data.ingredients

        }
    }
}