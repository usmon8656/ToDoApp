package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.Adapters.MyExpandableListAdapter
import com.example.todoapp.MyUtils.Cache
import com.example.todoapp.MyUtils.ToDoDeal
import com.example.todoapp.databinding.ActivityDealListBinding

class DealListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDealListBinding
    lateinit var map: HashMap<String, ArrayList<ToDoDeal>>
    lateinit var titleList:ArrayList<String>
    lateinit var myExpendAdapter: MyExpandableListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDealListBinding.inflate(layoutInflater)
        setTheme(androidx.appcompat.R.style.Theme_AppCompat)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        Cache.init(this)
        loadData()

        myExpendAdapter = MyExpandableListAdapter(map,titleList)
        binding.expandedList.setAdapter(myExpendAdapter)

        binding.expandedList.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val intent = Intent(this, InformationActivity::class.java)
            intent.putExtra("keyTodo", map[titleList[groupPosition]]?.get(childPosition))
            startActivity(intent)
            true
        }
    }

    private fun loadData() {
        map= HashMap()
        titleList= ArrayList()

        titleList.add("Open")
        titleList.add("Development")
        titleList.add("Uploading")
        titleList.add("Reject")
        titleList.add("Closed")

        val openList = ArrayList<ToDoDeal>()
        val uploadList = ArrayList<ToDoDeal>()
        val developList = ArrayList<ToDoDeal>()
        val rejectList = ArrayList<ToDoDeal>()
        val cloeList = ArrayList<ToDoDeal>()

        val list = Cache.obektString
        list.forEach {
            when(it.state){
                0 -> openList.add(it)
                1 -> developList.add(it)
                2 -> uploadList.add(it)
                3 -> rejectList.add(it)
                4 -> cloeList.add(it)
            }
        }

        map[titleList[0]] = openList
        map[titleList[1]] = developList
        map[titleList[2]] = uploadList
        map[titleList[3]] = rejectList
        map[titleList[4]] = cloeList

    }
}