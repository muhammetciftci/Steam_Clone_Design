package com.mtc.steam.homework4.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mtc.steam.homework4.databinding.ItemSpecialOffersLayoutBinding
import com.mtc.steam.homework4.model.Game

class SpecialOffersGameAdapter(private val gameList: ArrayList<Game>) :
    RecyclerView.Adapter<SpecialOffersGameAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: ItemSpecialOffersLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemSpecialOffersLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var layout = holder.binding
        val game = gameList[position]

        layout.gamePreviusPriceTextView.apply {
            paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            text = game.gamepreviousPrice
        }
        layout.imageView.setImageResource(
            holder.itemView.resources.getIdentifier(
                game.gameImage,
                "drawable",
                holder.itemView.context.packageName
            )
        )

        layout.gamePriceTextView.text = game.gamePrice
        layout.gameDiscountTextView.text = game.gamePriceDiscount

    }

    override fun getItemCount() = gameList.size
}