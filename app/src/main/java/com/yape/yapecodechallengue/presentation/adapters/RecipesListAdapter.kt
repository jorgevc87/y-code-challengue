package com.yape.yapecodechallengue.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.culqui.code.core.domain.Recipe
import com.yape.yapecodechallengue.R
import com.yape.yapecodechallengue.databinding.ItemListRecipeBinding

class RecipesListAdapter(private val context: Context) :
    RecyclerView.Adapter<RecipesListAdapter.RecipeViewHolder>() {

    private var listener: Listener? = null

    private val items = ArrayList<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_recipe, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int {
        return this.items.count()
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    fun setItems(items: List<Recipe>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class RecipeViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val binding = ItemListRecipeBinding.bind(v)

        fun bind(item: Recipe, position: Int) {
            binding.txtTitle.text = item.title

            Glide.with(context).load(item.img)
                .centerCrop()
                .into(binding.img)

            binding.itemLayout.setOnClickListener {
                listener?.onRecipeSelected(item)
            }
        }
    }

    interface Listener {
        fun onRecipeSelected(item: Recipe)
    }
}