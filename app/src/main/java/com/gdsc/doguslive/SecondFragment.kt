package com.gdsc.doguslive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdsc.doguslive.databinding.FragmentSecondBinding
import com.gdsc.doguslive.live.classsamples.MovieData

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val allUserList: ArrayList<String> = arrayListOf( // rastgele user listesi oluşturduk.
        "dogus uni",
        "istanbul üni",
        "meta",
        "google developer",
        "united state",
        "united kingdom",
        "turkey",
        "germany",
        "istanbul",
        "gdsc"
    )
    var adapter: SearchUserAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SearchUserAdapter(requireContext())

        binding.searchRecyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecyclerView.layoutManager = layoutManager

        adapter?.updateList(allUserList)
        binding.searchIcon.setOnClickListener {
            filterList(binding.searchEditText.text.toString()) // Arama butonuna basınca arama çubuğuna girilen text ile filterList fonksiyonunu çağırdık.
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun filterList(keyword: String) { // listeyi filtreleme için gerekli parametre alındı.
        val filteredList = allUserList.filter { item -> // tüm user'ı keyword'e göre filtreledik.
            item.contains(keyword)
        }

        adapter?.updateList(filteredList as ArrayList<String>) // "Android ile alakalı" sadece filtreleme işlemini ekrana uyguladık.
    }

    fun sortMoviesByPublishedYear() {
        val movieDataList: ArrayList<MovieData> =
            arrayListOf( // MovieData dataclassıyla bir liste oluşturuldu.
                MovieData(
                    "1", "Thor", 2011, arrayListOf("de", "eng"), true
                ), MovieData(
                    "2", "Iron Man", 2008, arrayListOf("de", "eng"), false
                ), MovieData(
                    "3", "The Flash", 2023, arrayListOf("de", "eng"), false
                )
            )

        val sortedList =
            movieDataList.sortBy { // movieDataList listesini publishedYear'a göre sıraladık
                it.publishedYear
            }

    }
}