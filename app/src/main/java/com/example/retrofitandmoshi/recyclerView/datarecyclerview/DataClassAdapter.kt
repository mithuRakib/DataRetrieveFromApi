package com.example.retrofitandmoshi.recyclerView.datarecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitandmoshi.data.userdata.DataClass
import com.example.retrofitandmoshi.databinding.SingleListItemBinding

class DataClassAdapter: RecyclerView.Adapter<DataClassViewHolder>() {
    var dataList = listOf<DataClass>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataClassViewHolder {
        val binding = SingleListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataClassViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataClassViewHolder, position: Int) {
        holder.dataOutput.text = dataList[position].name
    }

    override fun getItemCount(): Int = dataList.size
}