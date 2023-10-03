package com.yape.yapecodechallengue.presentation.view

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.bumptech.glide.Glide
import com.culqui.code.core.domain.Recipe
import com.culqui.code.core.domain.RecipeCoords
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yape.yapecodechallengue.R
import com.yape.yapecodechallengue.databinding.ActivityDetailscreenBinding
import com.yape.yapecodechallengue.databinding.ActivityHomescreenBinding
import com.yape.yapecodechallengue.databinding.ActivityMapscreenBinding
import com.yape.yapecodechallengue.presentation.adapters.RecipesListAdapter
import com.yape.yapecodechallengue.presentation.viewmodel.RecipeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapscreenBinding
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initMap()
    }

    private fun initMap() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync {
            mMap = it

            val title = intent?.extras?.getString(TITLE_RECIPE_BUNDLE_KEY, "No title")

            intent.extras?.getParcelable<RecipeCoords>(COORDS_RECIPE_BUNDLE_KEY)?.let { c ->
                val sydney = LatLng(c.lat.toDouble(), c.lng.toDouble())
                mMap.addMarker(
                    MarkerOptions()
                        .position(sydney)
                        .title(title)
                )
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15f))
            }
        }
    }

    companion object {
        const val COORDS_RECIPE_BUNDLE_KEY = "coords"
        const val TITLE_RECIPE_BUNDLE_KEY = "title"
    }
}