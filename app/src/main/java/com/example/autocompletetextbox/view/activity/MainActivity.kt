package com.example.autocompletetextbox.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autocompletetextbox.R
import com.example.autocompletetextbox.businesslogic.viewmodel.MainActivityViewModel
import com.example.autocompletetextbox.databinding.ActivityMainBinding
import com.example.autocompletetextbox.view.adapter.SuggestionsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel : MainActivityViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupRecyclerView()

    }

    private fun scrollToTop() {
        binding.rvSuggestions.scrollToPosition(0)
    }

    private fun setupRecyclerView() {
        val adapter = SuggestionsAdapter(binding.viewModel!!)
        binding.rvSuggestions.adapter = adapter
        binding.rvSuggestions.layoutManager = LinearLayoutManager(this)

        viewModel.suggestions.observe(this) { suggestions ->
            adapter.submitList(suggestions){
                scrollToTop()
            }
        }
    }
}