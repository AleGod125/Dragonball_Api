package com.example.dragonballapi.ui.Home.adapters

import com.bumptech.glide.Glide
import com.example.dragonballapi.databinding.ItemcharacterBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dragonballapi.domain.model.CharatesModel

class CharacterAdapter(private val characters: List<CharatesModel>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(private val binding: ItemcharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharatesModel) {
            binding.name.text = character.name
            binding.rasa.text = "${character.race} - ${character.gender}"
            binding.ki.text = character.ki
            binding.Tki.text = character.maxKi
            binding.Afilliation.text = character.affiliation

            Glide.with(binding.root.context)
                .load(character.image)
                .into(binding.imageViewCharacter)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemcharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount() = characters.size
}
