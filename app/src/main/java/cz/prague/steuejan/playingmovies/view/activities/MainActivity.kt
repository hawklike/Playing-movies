package cz.prague.steuejan.playingmovies.view.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import cz.prague.steuejan.playingmovies.BuildConfig
import cz.prague.steuejan.playingmovies.R
import cz.prague.steuejan.playingmovies.databinding.ActivityMainBinding
import cz.prague.steuejan.playingmovies.viewmodel.MainActivityVM

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainActivityVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getPlayingMovies()
    }
}
