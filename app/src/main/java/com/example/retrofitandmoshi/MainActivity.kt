package com.example.retrofitandmoshi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.retrofitandmoshi.databinding.ActivityMainBinding
import com.example.retrofitandmoshi.viewmodel.ActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
//        viewModel.response.observe(this, Observer {
//            it?.let {
//                binding.name.text = it
//            }
//        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.firebaseDatabaseActivity){
            startActivity(Intent(this, FirebaseDatabaseActivity::class.java))
        }
        return  true
    }
}