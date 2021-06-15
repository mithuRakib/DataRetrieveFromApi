package com.example.retrofitandmoshi.recyclerView.firebaseRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitandmoshi.R
import com.example.retrofitandmoshi.data.firebaseData.FirebaseDataMessage

class FirebaseDataAdapter: RecyclerView.Adapter<FirebaseDataViewHolder>() {
    var list = mutableListOf<FirebaseDataMessage?>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirebaseDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_list_item, parent, false)
        return FirebaseDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: FirebaseDataViewHolder, position: Int) {
        holder.textView.text = list[position]?.message
    }

    override fun getItemCount(): Int {
        return list.size
    }
}