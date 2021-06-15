package com.example.retrofitandmoshi.recyclerView.datarecyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitandmoshi.R
import com.example.retrofitandmoshi.databinding.SingleListItemBinding

class DataClassViewHolder(binding: SingleListItemBinding) :RecyclerView.ViewHolder(binding.root) {
    val dataOutput = binding.data
}