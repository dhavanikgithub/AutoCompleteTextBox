package com.example.autocompletetextbox.view.binding_adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.autocompletetextbox.R


@BindingAdapter(value = ["imageUrl"], requireAll = false)
fun ImageView.setImageUrl(url: String?)
{
    if (url != null) {
        Glide.with(this.context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(this)
    }
}