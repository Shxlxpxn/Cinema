package com.example.myapplication.view.fragments

import com.example.myapplication.view.rv_adapters.TopSpacingItemDecoration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.view.rv_adapters.FilmListRecyclerAdapter
import com.example.myapplication.view.MainActivity
import com.example.myapplication.utils.AnimationHelper
import com.example.myapplication.databinding.FragmentWatchLaterBinding
import com.example.myapplication.domain.Film

class WatchLaterFragment : Fragment() {

    private var _binding: FragmentWatchLaterBinding? = null
    private val binding
        get() = _binding!!
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWatchLaterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Получаем список при транзакции фрагмента
        val favoritesList: List<Film> = (requireActivity() as? MainActivity)?.getFilmsFromFavourites()!!

        binding.watchLaterRecycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                override fun click(film: Film) {
                    //Создаем бандл и кладем туда объект с данными фильма
                    val bundle = Bundle()
                    //Первым параметром указывается ключ, по которому потом будем искать, вторым сам
                    //передаваемы объект
                    bundle.putParcelable("film", film)
                    (requireActivity() as? MainActivity)?.let {
                        it.launchDetailsFragment(film)
                    }
                }
            })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireActivity())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(favoritesList)
        AnimationHelper.performFragmentCircularRevealAnimation(binding.root, requireActivity(), 2)
    }
}