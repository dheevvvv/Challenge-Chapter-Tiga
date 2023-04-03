package com.example.challenge_chapter3_dengannavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_chapter3_dengannavigation.databinding.FragmentAbjadBinding


@Suppress("DEPRECATION")
class FragmentAbjad : Fragment() {

    private lateinit var binding: FragmentAbjadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAbjadBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val abjadList = ('A'..'Z').map { DataAbjad(it.toString()) }

        val adapter = AdapterAbjad(abjadList as ArrayList<DataAbjad>) { dataAbjad ->
            val bundle = Bundle()
            bundle.putString("abjad", dataAbjad.toString())
            findNavController().navigate(R.id.action_fragmentAbjad_to_fragmentKata, bundle)
        }

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val recyclerView = binding.abjadRecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        var isGridLayout = false
        binding.ivArrowBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivGridOnOff.setOnClickListener {
            isGridLayout = !isGridLayout
            if (isGridLayout){
                binding.ivGridOnOff.setImageResource(R.drawable.ic_grid_on_foreground)
                recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
                recyclerView.adapter = adapter

            }else{
                binding.ivGridOnOff.setImageResource(R.drawable.ic_grid_off_foreground)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adapter
            }
        }

        binding.tvTitle.text = getString(R.string.titleFragmentAbjad)



    }



}

