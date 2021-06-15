package com.example.retrofitandmoshi.recyclerView.photorecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitandmoshi.R
import com.example.retrofitandmoshi.data.photodata.PhotoData
import com.example.retrofitandmoshi.databinding.SinglePhotoItemForListBinding
import com.squareup.picasso.Picasso

class PhotoAdapter: RecyclerView.Adapter<PhotoViewHolder>() {
    var list = listOf<PhotoData>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = SinglePhotoItemForListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }




    override fun getItemCount(): Int = list.size
}
