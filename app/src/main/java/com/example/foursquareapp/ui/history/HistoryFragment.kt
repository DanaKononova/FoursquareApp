package com.example.foursquareapp.ui.history

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foursquareapp.FoursquareApp
import com.example.foursquareapp.databinding.FragmentHistoryBinding
import com.example.foursquareapp.di.ViewModelFactory
import com.example.foursquareapp.ui.nearby.NearbyViewModel
import javax.inject.Inject

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: HistoryViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        (activity?.applicationContext as FoursquareApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}