package com.example.challenge_chapter3_tanpanavigation

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_chapter3_tanpanavigation.databinding.FragmentKataBinding
import java.util.*
import kotlin.collections.ArrayList

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class FragmentKata : Fragment() {

    private lateinit var binding: FragmentKataBinding
    private lateinit var kataList: List<DataKata>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKataBinding.inflate(layoutInflater,container, false)
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundle = arguments
        val abjad = bundle?.getString("abjad")


        kataList = getKataList(abjad)

        val adapter = AdapterKata(kataList as ArrayList<DataKata>, this)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val recyclerView = binding.kataRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        var isGridLayout = false
        binding.ivArrowBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivGridOnOff.setOnClickListener {
            isGridLayout = !isGridLayout
            if (isGridLayout){
                binding.ivGridOnOff.setImageResource(R.drawable.ic_grid_foreground)
                recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
                recyclerView.adapter = adapter

            }else{
                binding.ivGridOnOff.setImageResource(R.drawable.ic_grid_off_foreground)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adapter
            }
        }

        binding.tvTitle.text = getString(R.string.titleFragmentKata) + "  " + abjad

    }

    fun onKataClicked(kata: DataKata) {
        val query = "https://www.google.com/search?q=${kata.kata}+arti"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(query))
        startActivity(intent)
    }

    private fun getKataList(abjad: String?): ArrayList<DataKata> = when (abjad) {
        "A" -> arrayListOf(
            DataKata("Api"),
            DataKata("Awan"),
            DataKata("Abu")
        )
        "B" -> arrayListOf(
            DataKata("Becak"),
            DataKata("Bulu"),
            DataKata("Badak")
        )
        "C" -> arrayListOf(
            DataKata("Cicak"),
            DataKata("Cabai"),
            DataKata("Cilok")
        )
        "D" -> arrayListOf(
            DataKata("Domba"),
            DataKata("Dukun"),
            DataKata("Dusun")
        )
        "E" -> arrayListOf(
            DataKata("Entog"),
            DataKata("Elang"),
            DataKata("Ebi")
        )
        "F" -> arrayListOf(
            DataKata("Flamingo"),
            DataKata("Flavor"),
            DataKata("Fanta")
        )
        "G" -> arrayListOf(
            DataKata("Gala"),
            DataKata("Gendong"),
            DataKata("Grock")
        )
        "H" -> arrayListOf(
            DataKata("Hantu"),
            DataKata("Hindi"),
            DataKata("Husnul")
        )
        "I" -> arrayListOf(
            DataKata("Iguana"),
            DataKata("Indonesia"),
            DataKata("Implisit")
        )
        "J" -> arrayListOf(
            DataKata("Jakarta"),
            DataKata("Jambu"),
            DataKata("Jerome")
        )
        "K" -> arrayListOf(
            DataKata("Kuil"),
            DataKata("Kudus"),
            DataKata("Kikir")
        )
        "L" -> arrayListOf(
            DataKata("Loba"),
            DataKata("Langka"),
            DataKata("Lalap")
        )
        "M" -> arrayListOf(
            DataKata("Montenegoro"),
            DataKata("Medal"),
            DataKata("Mandi")
        )
        "N" -> arrayListOf(
            DataKata("Naungan"),
            DataKata("Nila"),
            DataKata("Nekat")
        )
        "O" -> arrayListOf(
            DataKata("Obok"),
            DataKata("Osaka"),
            DataKata("Okinawa")
        )
        "P" -> arrayListOf(
            DataKata("Planton"),
            DataKata("Puisi"),
            DataKata("Pantun")
        )
        "Q" -> arrayListOf(
            DataKata("Quartal"),
            DataKata("Quran"),
            DataKata("Queen")
        )
        "R" -> arrayListOf(
            DataKata("Rimba"),
            DataKata("Reksa"),
            DataKata("Rivian")
        )
        "S" -> arrayListOf(
            DataKata("Sambal"),
            DataKata("Solo"),
            DataKata("Sate")
        )
        "T" -> arrayListOf(
            DataKata("Tupai"),
            DataKata("Tuku"),
            DataKata("Teuku")
        )
        "U" -> arrayListOf(
            DataKata("Ukulele"),
            DataKata("Ubur"),
            DataKata("Unta")
        )
        "V" -> arrayListOf(
            DataKata("Vuitton"),
            DataKata("Villa"),
            DataKata("Vatikan")
        )
        "W" -> arrayListOf(
            DataKata("Wolf"),
            DataKata("Wu"),
            DataKata("Wei")
        )
        "X" -> arrayListOf(
            DataKata("Domba"),
            DataKata("Dukun"),
            DataKata("Dusun")
        )
        "Y" -> arrayListOf(
            DataKata("Xi"),
            DataKata("Xhu"),
            DataKata("Xiao")
        )
        "Z" -> arrayListOf(
            DataKata("Zara"),
            DataKata("Zata"),
            DataKata("Zebra")
        )

        else -> arrayListOf()
    }






}