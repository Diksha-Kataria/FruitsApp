package com.example.fruitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitapp.retrofit.ApiInterface
import com.example.fruitapp.retrofit.ServiceBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var fruits: ArrayList<Fruit> = ArrayList()
    lateinit var fruitListAdapter : FruitListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        getFruits()
    }

    private fun getFruits() {
        val request = ServiceBuilder.buildService(ApiInterface::class.java)
        val call = request.getFruits()
        call.enqueue(object : Callback<ArrayList<Fruit>> {
            override fun onResponse(
                call: Call<ArrayList<Fruit>>,
                response: Response<ArrayList<Fruit>>
            ) {
                if (response.body() != null && response.isSuccessful) {
                    fruits.addAll(response.body()!!)
                    fruitListAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ArrayList<Fruit>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Please try again", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun initViews() {
        fruitListAdapter = FruitListAdapter(fruits, this@MainActivity)
        val rvFruits = findViewById<RecyclerView>(R.id.rvFruits)
        var fabNewFruit = findViewById<FloatingActionButton>(R.id.fabAddNewFruit)
        rvFruits.adapter = fruitListAdapter
        rvFruits.layoutManager = LinearLayoutManager(this)
        fabNewFruit.setOnClickListener{
            val intent = Intent(this@MainActivity, AddFruit:: class.java)
            startActivity(intent)
        }
    }
}