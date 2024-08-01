package com.example.autocompletetextbox.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.autocompletetextbox.businesslogic.diff.CountryDiffCallback
import com.example.autocompletetextbox.businesslogic.pojo.Country
import com.example.autocompletetextbox.businesslogic.viewmodel.MainActivityViewModel
import com.example.autocompletetextbox.databinding.ItemSuggestionBinding
import com.example.autocompletetextbox.view.viewholder.SuggestionViewHolder

class SuggestionsAdapter(val viewModel: MainActivityViewModel) : ListAdapter<Country, SuggestionViewHolder>(
    CountryDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {
        val binding = ItemSuggestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SuggestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {
        holder.bind(getItem(position), viewModel)
    }
}
