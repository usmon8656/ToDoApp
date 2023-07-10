package com.example.todoapp.MyUtils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Cache {
    private const val NAME = "KeshXotiraga"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences:SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(
            NAME,
            MODE
        )
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var obektString: ArrayList<ToDoDeal>
        get() = gsonStringToArray(preferences.getString("object", "[]")!!)
        set(value) = preferences.edit {
            if (value != null){
                it.putString("object", arrayToGsonString(value))
            }
        }

    fun arrayToGsonString(arrayList: ArrayList<ToDoDeal>): String{
        return Gson().toJson(arrayList)
    }

    fun gsonStringToArray(gsonString: String): ArrayList<ToDoDeal>{
        val list = ArrayList<ToDoDeal>()
        val typeToken = object : TypeToken<ArrayList<ToDoDeal>>(){}.type
        list.addAll(Gson().fromJson(gsonString, typeToken))
        return list
    }
}