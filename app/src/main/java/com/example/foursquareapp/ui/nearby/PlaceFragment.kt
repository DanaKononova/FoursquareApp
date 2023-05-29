package com.example.foursquareapp.ui.nearby

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foursquareapp.FoursquareApp
import com.example.foursquareapp.R
import com.example.foursquareapp.databinding.FragmentPlaceBinding
import com.example.foursquareapp.di.ViewModelFactory
import java.lang.reflect.Field
import javax.inject.Inject

class PlaceFragment : Fragment() {

    private val args: PlaceFragmentArgs by navArgs()
    private var _binding: FragmentPlaceBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: PlaceViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        (activity?.applicationContext as FoursquareApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.fragmentTv.text = getString(R.string.nearby)

        val recycler = binding.placeRecycler
        val adapter = DescriptionAdapter()
        recycler.adapter = adapter
        recycler.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        val imageRecyclerView = binding.imageRecycler
        val imageAdapter = ImageAdapter()
        imageRecyclerView.adapter = imageAdapter
        imageRecyclerView.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)

        viewModel.descriptionLiveData.observe(viewLifecycleOwner){
            val fields: Array<Field> = it.javaClass.declaredFields
            val items = mutableListOf<String>()
            for (field in fields){
                items.add(field.name)
            }
            val values = listOf(it.address, it.country, it.cross_street, it.fsq_id, it.latitude.toString(), it.longitude.toString(), it.name, it.prefix, it.region, it.suffix, it.timezone, it.typeName)
            adapter.setPlaces(items, values)
        }

        viewModel.photosLiveData.observe(viewLifecycleOwner){
            val images = mutableListOf<String>()
            if (it.isNotEmpty()) {
                for (item in it){
                    val photoUrl = item.prefix + "original" + item.suffix
                    images.add(photoUrl)
                }
                imageAdapter.setImages(images)
            }
        }

        binding.backBt.setOnClickListener {
            val action = PlaceFragmentDirections.actionNavigationPlaceToNavigationSearch()
            findNavController().navigate(action)
        }

        viewModel.getPlaceDescription(args.id)
        viewModel.getPhotos(args.id)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}