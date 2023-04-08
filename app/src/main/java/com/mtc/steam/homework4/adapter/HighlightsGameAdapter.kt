package com.mtc.steam.homework4.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mtc.steam.homework4.databinding.ItemHighlightsLayoutBinding
import com.mtc.steam.homework4.model.Game

class HighlightsGameAdapter(private val gameList: ArrayList<Game>) :
    RecyclerView.Adapter<HighlightsGameAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: ItemHighlightsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ItemHighlightsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var layout = holder.binding
        val game = gameList[position]
        layout.gameNameTextView.text = game.gameName
        layout.gamePrice.text = game.gamePrice
        layout.imageView.setImageResource(
            holder.itemView.resources.getIdentifier(
                game.gameImage,
                "drawable",
                holder.itemView.context.packageName
            )
        )

    }

    override fun getItemCount() = gameList.size
}