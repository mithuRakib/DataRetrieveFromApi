package com.example.retrofitandmoshi.recyclerView.firebaseRecyclerView

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitandmoshi.R

class FirebaseDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView = itemView.findViewById<TextView>(R.id.data)
}