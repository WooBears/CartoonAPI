package com.example.rickapi2ndex.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickapi2ndex.databinding.ItemCartoonBinding
import com.example.rickapi2ndex.model.Character
import com.example.rickapi2ndex.model.Result
import com.squareup.picasso.Picasso

class CartoonAdapter : RecyclerView.Adapter<CartoonAdapter.CartoonViewHolder>() {

    private var cartoons = arrayListOf<Result>()

    @SuppressLint("NotifyDataSetChanged")
    fun addCartoon(character: List<Result>){
        cartoons.clear()
        cartoons.addAll(character)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartoonAdapter.CartoonViewHolder {
       return CartoonViewHolder(ItemCartoonBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false
       ))
    }

    override fun onBindViewHolder(holder: CartoonAdapter.CartoonViewHolder, position: Int) {
        holder.bind(cartoons[position])
    }

    override fun getItemCount(): Int {
        return cartoons.size
    }

    inner class CartoonViewHolder(private val binding: ItemCartoonBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(context: Result){

            binding.ciAliveStatus.visibility = View.GONE
            binding.ciDeadStatus.visibility = View.GONE
            binding.ciUnknownStatus.visibility = View.GONE

            when (context.status) {
                "Alive" -> binding.ciAliveStatus.visibility = View.VISIBLE
                "Dead" -> binding.ciDeadStatus.visibility = View.VISIBLE
                "unknown" -> binding.ciUnknownStatus.visibility = View.VISIBLE
            }

                binding.tvName.text = context.name
                binding.tvStatus.text = context.status
                binding.tvSpecies.text = context.species
                binding.tvLocation.text = context.location.name
                binding.tvLocationSecond.text = context.origin.name
                Picasso.get().load(context.image).into(binding.ivImage)
       }
    }
}