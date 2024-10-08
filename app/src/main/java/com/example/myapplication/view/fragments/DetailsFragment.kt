package com.example.myapplication.view.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication.view.MainActivity
import com.example.myapplication.R
import com.example.myapplication.data.ApiConstants
import com.example.myapplication.databinding.FragmentDetailsBinding
import com.example.myapplication.domain.Film

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding
        get() = _binding!!
    private val film: Film? by lazy {
        arguments?.getParcelable("film")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFilmsDetails()

        binding.detailsFabShare.setOnClickListener {
            //Создаем интент
            val intent = Intent()
            //Укзываем action с которым он запускается
            intent.action = Intent.ACTION_SEND
            //Кладем данные о нашем фильме
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Check out this film: ${film?.title} \n\n ${film?.description}"
            )
            //УКазываем MIME тип, чтобы система знала, какое приложения предложить
            intent.type = "text/plain"
            //Запускаем наше активити
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }

    private fun setFilmsDetails() {
        film?.let { film ->
            Glide.with(this)
                .load(ApiConstants.IMAGES_URL + "w780" + film.poster)
                .centerCrop()
                .into(binding.detailsPoster)
            with(binding) {
                detailsToolbar.title = film.title
                detailsDescription.text = film.description
                detailsFabFavorites.setImageResource(
                    if (film.isInFavorites) R.drawable.favourites_yes
                    else R.drawable.favourites
                )
                detailsFabFavorites.setOnClickListener {
                    if (!film.isInFavorites) {
                        (requireActivity() as? MainActivity)?.addFilmToFavourites(film)
                        detailsFabFavorites.setImageResource(R.drawable.favourites_yes)
                        film.isInFavorites = true
                    } else {
                        (requireActivity() as? MainActivity)?.removeFilmToFavourites(film)
                        detailsFabFavorites.setImageResource(R.drawable.favourites)
                        film.isInFavorites = false
                    }
                }
            }
        } ?: AlertDialog.Builder(requireContext()).show()
    }
}