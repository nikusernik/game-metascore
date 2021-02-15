package com.hgabriel.videogames.scores.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hgabriel.videogames.scores.databinding.BottomSheetAddGameBinding

class AddGameBottomSheet(
    private val onSave: (gamePath: String?) -> Unit
) : BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetAddGameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetAddGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.tvSave.setOnClickListener {
            onSave(binding.tiGamePath.editText?.text.toString())
            this.dismiss()
        }
    }
}