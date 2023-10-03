package com.yape.yapecodechallengue.presentation.view

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.culqui.code.core.domain.Recipe
import com.yape.yapecodechallengue.databinding.ActivityHomescreenBinding
import com.yape.yapecodechallengue.presentation.adapters.RecipesListAdapter
import com.yape.yapecodechallengue.presentation.viewmodel.RecipeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomescreenBinding
    private val viewModel: RecipeViewModel by viewModel()

    private val recipesListAdapter: RecipesListAdapter by lazy {
        RecipesListAdapter(this@HomeScreenActivity).apply {
            this.setListener(object : RecipesListAdapter.Listener {
                override fun onRecipeSelected(item: Recipe) {
                    startActivity(
                        Intent(
                            this@HomeScreenActivity,
                            DetailScreenActivity::class.java
                        ).apply {
                            putExtras(Bundle().apply {
                                putParcelable(DetailScreenActivity.RECIPE_BUNDLE_KEY, item)
                            })
                        })
                }
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomescreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configObservers()

        configViews()

        viewModel.getRecipes()
    }

    private fun configViews() {
        binding.listRecipes.layoutManager = LinearLayoutManager(this)
        binding.listRecipes.adapter = recipesListAdapter
    }

    private fun configObservers() {
        viewModel.getReceipesResult.observe(this, { result ->
            result?.let { r ->
                recipesListAdapter.setItems(r)
            }
        })
    }
}