package com.example.autocompletetextbox.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.autocompletetextbox.businesslogic.pojo.Country
import com.example.autocompletetextbox.businesslogic.viewmodel.MainActivityViewModel
import com.example.autocompletetextbox.databinding.ItemSuggestionBinding
import com.example.autocompletetextbox.utils.Constants.Companion.MAIN_URL

class SuggestionViewHolder(private val binding: ItemSuggestionBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(countryItem: Country, viewModel: MainActivityViewModel) {
        binding.country = countryItem
        binding.viewModel = viewModel
        binding.imageUrl = "${MAIN_URL}/png100px/${countryItem.code.lowercase()}.png"
        binding.executePendingBindings()
    }
}