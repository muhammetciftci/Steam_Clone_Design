package com.mtc.steam.homework4.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mtc.steam.homework4.R
import com.mtc.steam.homework4.adapter.HighlightsGameAdapter
import com.mtc.steam.homework4.adapter.SpecialOffersGameAdapter
import com.mtc.steam.homework4.databinding.FragmentShopBinding
import com.mtc.steam.homework4.model.Game

class ShopFragment : Fragment() {

    private lateinit var binding: FragmentShopBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShopBinding.inflate(inflater, container, false)

        cuzdanSetText()
        bottomSheetDialog()
        loadHighlightsData()
        loadSpecialsData()


        return binding.root
    }

    fun loadHighlightsData(){
        val gameList = ArrayList<Game>()
        val game1 = Game("Counter Strike: Global Offensive","counterstrike","Oynaması Ücretsiz",null,null)
        val game2 = Game("Assassin’s Creed® IV Black Flag™","acblackflag","469,00 TL",null,null)
        val game3 = Game("Red Dead Redemption 2","rdr","1150,00 TL",null,null)
        val game4 = Game("The Last of Us™ Part I","thelastofus","599,00 TL",null,null)
        val game5 = Game("Sons Of The Forest","sonsoftheforest","280,00 TL",null,null)
        gameList.add(game1)
        gameList.add(game2)
        gameList.add(game3)
        gameList.add(game4)
        gameList.add(game5)
        val highlightsGameAdapter = HighlightsGameAdapter(gameList)
        binding.highlightsRecylerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.highlightsRecylerView.adapter = highlightsGameAdapter
    }

    fun loadSpecialsData(){
        val gameList = ArrayList<Game>()
        val game1 = Game("EA SPORTS™ FIFA 23","fifa","209,99 TL","-70%","699,99 TL")
        val game2 = Game("Euro Truck Simulator 2","ets","37,25 TL","-75%","149,99 TL")
        val game3 = Game("Battlefield™ V","battlefield","124,99 TL","-75%","499,99 TL")
        val game4 = Game("Mafia: Definitive Edition","mafia","90,65 TL","-65%","259,00 TL")
        gameList.add(game1)
        gameList.add(game2)
        gameList.add(game3)
        gameList.add(game4)
        val specialOffersGameAdapter = SpecialOffersGameAdapter(gameList)
        binding.specialOffersRecylerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
        binding.specialOffersRecylerView.adapter = specialOffersGameAdapter
    }

    fun bottomSheetDialog(){
        binding.menuShopSheetImageView.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.shop_bottom_sheet, null)
            dialog.setContentView(view)
            dialog.show()
        }
    }

    fun cuzdanSetText(){
        val colorBlue = ContextCompat.getColor(requireContext(), R.color.cuzdan_bakiye_text_color)
        val text = "CÜZDAN <b><font color='$colorBlue'>(27,27 TL)</font></b>"
        binding.cuzdanTextview.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

}