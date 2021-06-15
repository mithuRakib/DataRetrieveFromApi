package com.example.retrofitandmoshi.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.retrofitandmoshi.R
import com.example.retrofitandmoshi.databinding.FragmentPhotoListBinding
import com.example.retrofitandmoshi.recyclerView.photorecyclerview.PhotoAdapter
import com.example.retrofitandmoshi.viewmodel.PhotoListViewModel
import com.squareup.picasso.Picasso

class PhotoListFragment : Fragment() {
   private lateinit var binding: FragmentPhotoListBinding
   private lateinit var viewModel: PhotoListViewModel
   private lateinit var adapter:PhotoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo_list, container, false)
        viewModel = ViewModelProvider(this).get(PhotoListViewModel::class.java)

        adapter = PhotoAdapter()
        binding.photoRecyclerView.hasFixedSize()
        binding.photoRecyclerView.adapter = adapter

        viewModel.photoList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.list = it
                Log.d("ViewModel::", it.toString())
            }
        })

        viewModel.photo.observe(viewLifecycleOwner, Observer {

        })

        return binding.root
    }

}