package com.example.autocompletetextbox.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.autocompletetextbox.businesslogic.pojo.Country
import com.example.autocompletetextbox.businesslogic.pojo.Suggestion
import com.example.autocompletetextbox.businesslogic.viewmodel.MainActivityViewModel
import com.example.autocompletetextbox.databinding.ItemSuggestionBinding

class SuggestionsAdapter(val viewModel: MainActivityViewModel) : ListAdapter<Country, SuggestionsAdapter.SuggestionViewHolder>(DiffCallback()) {

    class SuggestionViewHolder(private val binding: ItemSuggestionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(countryItem: Country, viewModel: MainActivityViewModel) {
            binding.country = countryItem
            binding.viewModel = viewModel
            val imageUrl = "https://raw.githubusercontent.com/hampusborgos/country-flags/main/png100px/${countryItem.code.lowercase()}.png"
            Glide.with(binding.root.context)
                .load(imageUrl)
                .into(binding.countryFlag)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {
        val binding = ItemSuggestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SuggestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {
        holder.bind(getItem(position), viewModel)
    }



    class DiffCallback : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.code == newItem.code
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }
    }
}
