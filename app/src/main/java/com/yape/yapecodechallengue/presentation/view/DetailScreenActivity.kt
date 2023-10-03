package com.yape.yapecodechallengue.presentation.view

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.bumptech.glide.Glide
import com.culqui.code.core.domain.Recipe
import com.yape.yapecodechallengue.databinding.ActivityDetailscreenBinding
import com.yape.yapecodechallengue.databinding.ActivityHomescreenBinding
import com.yape.yapecodechallengue.presentation.adapters.RecipesListAdapter
import com.yape.yapecodechallengue.presentation.viewmodel.RecipeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configViews()
    }

    private fun configViews() {
        intent?.extras?.getParcelable<Recipe>(RECIPE_BUNDLE_KEY)?.let { r ->
            Glide.with(this@DetailScreenActivity).load(r.img)
                .centerCrop()
                .into(binding.imgHeader)

            binding.txtTitle.text = r.title
            binding.txtDesc.text = r.desc

            r.coords?.let { c ->
                binding.btnLocation.setOnClickListener {
                    startActivity(
                        Intent(
                            this@DetailScreenActivity,
                            MapScreenActivity::class.java
                        ).apply {
                            putExtras(Bundle().apply {
                                putString(MapScreenActivity.TITLE_RECIPE_BUNDLE_KEY, r.title)
                                putParcelable(MapScreenActivity.COORDS_RECIPE_BUNDLE_KEY, c)
                            })
                        })
                }
            }
        }
    }

    companion object {
        const val RECIPE_BUNDLE_KEY = "recipe"
    }
}