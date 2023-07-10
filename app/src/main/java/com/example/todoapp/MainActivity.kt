package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp.MyUtils.MySpinnerData
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.ui.theme.ToDoAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setTheme(androidx.appcompat.R.style.Theme_AppCompat)
        setContentView(binding.root)

        binding.btnDo.setOnClickListener {
            val intent = Intent(this,DealListActivity::class.java )
            startActivity(intent)
        }

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this,AddDealActivity::class.java )
            startActivity(intent)
        }
    }
}