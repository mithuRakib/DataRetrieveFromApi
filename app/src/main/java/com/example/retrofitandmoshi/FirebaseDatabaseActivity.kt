package com.example.retrofitandmoshi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginTop
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitandmoshi.data.firebaseData.FirebaseDataMessage
import com.example.retrofitandmoshi.recyclerView.datarecyclerview.DataClassAdapter
import com.example.retrofitandmoshi.recyclerView.firebaseRecyclerView.FirebaseDataAdapter
import com.google.firebase.database.*

class FirebaseDatabaseActivity : AppCompatActivity() {
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    private lateinit var valueEventListener: ValueEventListener
    private lateinit var childEventListener: ChildEventListener

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FirebaseDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_database)


        recyclerView = findViewById(R.id.firebaseRv)
        adapter = FirebaseDataAdapter()
        recyclerView.adapter = adapter



        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("messages")

        childEventListener = object : ChildEventListener{
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val msg = snapshot.getValue(FirebaseDataMessage::class.java)
                adapter.list.add(msg as FirebaseDataMessage)
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }


        databaseReference.addChildEventListener(childEventListener)

        val msg = findViewById<EditText>(R.id.editText)
        val btn = findViewById<Button>(R.id.submit)

        btn.setOnClickListener(View.OnClickListener {
            databaseReference.push().setValue(FirebaseDataMessage(msg.text.toString()))

            msg.text.clear()
        })
    }
}