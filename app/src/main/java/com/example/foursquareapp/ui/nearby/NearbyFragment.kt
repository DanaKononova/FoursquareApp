package com.example.foursquareapp.ui.nearby

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foursquareapp.FoursquareApp
import com.example.foursquareapp.databinding.FragmentNearbyBinding
import com.example.foursquareapp.di.ViewModelFactory
import javax.inject.Inject

class NearbyFragment : Fragment() {

    private var _binding: FragmentNearbyBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: NearbyViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        (activity?.applicationContext as FoursquareApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNearbyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val itemClick: (String) -> Unit = { id ->
            val action =
                NearbyFragmentDirections.actionNavigationSearchToNavigationPlace(id)
            findNavController().navigate(action)
        }

        val recycler = binding.placesRecycler
        val adapter = PlacesAdapter(itemClick)
        recycler.adapter = adapter
        recycler.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        viewModel.placesLiveData.observe(viewLifecycleOwner) {
            adapter.setPlaces(it)
        }

        viewModel.getPlaces("53.9057644,27.5582305", 4000, 30, requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}