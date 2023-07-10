package com.example.todoapp

//noinspection SuspiciousImport
import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.todoapp.Adapters.MySpinnerAdapter
import com.example.todoapp.MyUtils.Cache
import com.example.todoapp.MyUtils.MySpinnerData
import com.example.todoapp.MyUtils.ToDoDeal
import com.example.todoapp.databinding.ActivityAddDealBinding

class AddDealActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddDealBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddDealBinding.inflate(layoutInflater)
        setTheme(androidx.appcompat.R.style.Theme_AppCompat)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Add todo"


        binding.spinner.adapter = MySpinnerAdapter(MySpinnerData.list)
        Cache.init(this)

        binding.btnSave.setOnClickListener {
            binding.apply {
                var toDoDeal = ToDoDeal(edtName.text.toString(),edtDescription.text.toString(),spinner.selectedItem.toString(),edtDate.text.toString(),edtDeadline.text.toString())
                val list = Cache.obektString
                list.add(toDoDeal)
                Cache.obektString = list
                finish()
            }
        }
    }
}