package com.example.autocompletetextbox.businesslogic.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.autocompletetextbox.businesslogic.pojo.Country

class CountryDiffCallback : DiffUtil.ItemCallback<Country>() {
    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.code == newItem.code
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }
}