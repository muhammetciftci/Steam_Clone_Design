package com.mtc.steam.homework4.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mtc.steam.homework4.R
import com.mtc.steam.homework4.databinding.FragmentNewspaperBinding


class NewspaperFragment : Fragment() {


    private lateinit var binding:FragmentNewspaperBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewspaperBinding.inflate(inflater,container,false)

        bottomSheetDialog()


        return binding.root

    }


    fun bottomSheetDialog(){
        binding.menuShopSheetImageView.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.newspaper_bottom_sheet, null)
            dialog.setContentView(view)
            dialog.show()
        }
    }


}