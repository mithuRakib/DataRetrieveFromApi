package com.example.retrofitandmoshi.recyclerView.photorecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitandmoshi.R
import com.example.retrofitandmoshi.data.photodata.PhotoData
import com.example.retrofitandmoshi.databinding.SinglePhotoItemForListBinding
import com.squareup.picasso.Picasso

class PhotoViewHolder(val binding: SinglePhotoItemForListBinding) : RecyclerView.ViewHolder(binding.root) {
    private val photo = binding.photoThumb
//    private val title = binding.photoTitle
    fun bind(item: PhotoData) {
        binding.photoData = item
//        title.text = item.title
        Picasso.get().load(item.thumbUrl)
                .placeholder(R.drawable.ic_baseline_image_24)
                .error(R.drawable.ic_baseline_error_24)
                .into(photo)
    }
}