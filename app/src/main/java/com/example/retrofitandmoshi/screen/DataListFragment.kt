package com.example.retrofitandmoshi.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitandmoshi.R
import com.example.retrofitandmoshi.databinding.FragmentDataListBinding
import com.example.retrofitandmoshi.recyclerView.datarecyclerview.DataClassAdapter
import com.example.retrofitandmoshi.viewmodel.ActivityViewModel

class DataListFragment : Fragment() {
    private lateinit var binding: FragmentDataListBinding
    private lateinit var viewModel: ActivityViewModel
    private lateinit var adapter: DataClassAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data_list, container, false)
//        binding = FragmentDataListBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        binding.rv.hasFixedSize()
        adapter = DataClassAdapter()
        binding.rv.adapter = adapter
        viewModel.listUser.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.dataList = it
                Log.d("ViewModel: ", it.toString())
            }
        })

        return binding.root
    }

}