package com.example.fruitapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.fruitapp.retrofit.ApiInterface
import com.example.fruitapp.retrofit.ServiceBuilder
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddFruit : AppCompatActivity() {
    lateinit var etName: AppCompatEditText
    lateinit var etFamilyName: AppCompatEditText
    lateinit var etGenusName: AppCompatEditText
    lateinit var etCarbohydrate: AppCompatEditText
    lateinit var etProtein: AppCompatEditText
    lateinit var etSugar: AppCompatEditText
    lateinit var etFat: AppCompatEditText
    lateinit var etCalories: AppCompatEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_fruit)
        this@AddFruit.title = "Add a fruit"
        initViews()


    }

    private fun initViews() {
        etName = findViewById<AppCompatEditText>(R.id.etFruitName)
        etFamilyName = findViewById<AppCompatEditText>(R.id.etFamilyName)
        etGenusName = findViewById<AppCompatEditText>(R.id.etGenusName)
        etCarbohydrate = findViewById<AppCompatEditText>(R.id.etCarbohydrateValue)
        etProtein = findViewById<AppCompatEditText>(R.id.etProteinValue)
        etSugar = findViewById<AppCompatEditText>(R.id.etSugarValue)
        etFat = findViewById<AppCompatEditText>(R.id.etFatValue)
        etCalories = findViewById<AppCompatEditText>(R.id.etCaloriesValue)
        var bAddFruit = findViewById<AppCompatButton>(R.id.bAddFruit)
        bAddFruit.setOnClickListener{
            validateInputs()
        }
    }

    private fun validateInputs() {
        if(etName.text?.isEmpty()!!){
            Toast.makeText(this@AddFruit, "Please enter the name", Toast.LENGTH_SHORT).show()
            return
        }
        if(etFamilyName.text!= null && etFamilyName.text?.isEmpty()!!){
            Toast.makeText(this@AddFruit, "Please enter the family name", Toast.LENGTH_SHORT).show()
            return
        }
        if(etGenusName.text?.isEmpty()!!) {
            Toast.makeText(this@AddFruit, "Please enter the genus name", Toast.LENGTH_SHORT).show()
            return
        }
        if(etCarbohydrate.text?.isEmpty()!!) {
            Toast.makeText(
                this@AddFruit,
                "Please enter the amount of carbohydrates",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        if(etProtein.text?.isEmpty()!!) {
            Toast.makeText(this@AddFruit, "Please enter the amount of protein", Toast.LENGTH_SHORT).show()
            return
        }
        if(etSugar.text?.isEmpty()!!) {
            Toast.makeText(this@AddFruit, "Please enter the amount of sugar", Toast.LENGTH_SHORT).show()
            return
        }
        if(etFat.text?.isEmpty()!!) {
            Toast.makeText(this@AddFruit, "Please enter the amount of fat", Toast.LENGTH_SHORT).show()
            return
        }
        if(etCalories.text?.isEmpty()!!) {
            Toast.makeText(this@AddFruit, "Please enter the amount of calories", Toast.LENGTH_SHORT).show()
            return
        }

        addFruit()
    }

    private fun addFruit() {
        var nutrition = Nutrition(
            etCarbohydrate.text.toString().toFloat(),
            etProtein.text.toString().toFloat(),
            etSugar.text.toString().toFloat(),
            etFat.text.toString().toFloat(),
            etCalories.text.toString().toFloat()
        )
        var fruit = Fruit(
            etName.text.toString(),
            etFamilyName.text.toString(),
            nutrition,
            etGenusName.text.toString()
        )

        val request = ServiceBuilder.buildService(ApiInterface::class.java)
        val call = request.addFruit(fruit)
        call.enqueue(object : Callback<Fruit> {
            override fun onResponse(
                call: Call<Fruit>,
                response: Response<Fruit>
            ) {
                if (response.body() != null && response.isSuccessful) {
                }
            }

            override fun onFailure(call: Call<Fruit>, t: Throwable) {
                Toast.makeText(this@AddFruit, "Please try again", Toast.LENGTH_SHORT).show()
            }

        })
    }
}