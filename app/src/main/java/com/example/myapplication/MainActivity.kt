package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val favorites = mutableListOf<Film>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentPlaceholder.id, HomeFragment())
                .commit()
        }
        initNavigation()
    }

    fun launchDetailsFragment(film: Film) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .addToBackStack(null)
            .replace(binding.fragmentPlaceholder.id, DetailsFragment().apply {
                val bundle = Bundle()
                bundle.putParcelable("film", film)
                arguments = bundle
            })
            .commit()
    }

    fun addFilmToFavourites(film: Film) {
        favorites.add(film)
    }
    fun removeFilmToFavourites(film: Film) {
        favorites.remove(film)
    }
    fun getFilmsFromFavourites(): List<Film> = favorites

    private fun initNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.main_page -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentPlaceholder.id, HomeFragment())
                        .addToBackStack("Главная") // Add a name for back stack entry
                        .commit()
                    true
                }
                R.id.favorites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentPlaceholder.id, FavoritesFragment())
                        .addToBackStack("favorites") // Add a name for back stack entry
                        .commit()
                    true
                }
                R.id.watch_later -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentPlaceholder.id, WatchLaterFragment())
                        .addToBackStack("Посмотреть позже") // Add a name for back stack entry
                        .commit()
                    true
                }
                R.id.selections -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragmentPlaceholder.id, SelectionsFragment())
                        .addToBackStack("Подборки") // Add a name for back stack entry
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
  //  private fun checkFragmentExistence(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment, tag)
            .addToBackStack(null)
            .commit()
    }
}


