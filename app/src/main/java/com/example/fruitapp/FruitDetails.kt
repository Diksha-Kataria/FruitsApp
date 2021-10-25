package com.example.fruitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FruitDetails : AppCompatActivity() {
    var fruit: Fruit? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_details)
        fruit = intent.getParcelableExtra("FruitDetails")
        initViews()
        this@FruitDetails.title = fruit?.name

    }

    private fun initViews() {
        var tvFamilyName = findViewById<TextView>(R.id.tvFamilyName)
        tvFamilyName.text = fruit?.family
        var tvGenusName = findViewById<TextView>(R.id.tvGenusName)
        tvGenusName.text = fruit?.genus
        var tvCarbohydrate = findViewById<TextView>(R.id.tvCarbohydrateValue)
        tvCarbohydrate.text = fruit?.nutritions?.carbohydrates.toString()
        var tvProtein = findViewById<TextView>(R.id.tvProteinValue)
        tvProtein.text = fruit?.nutritions?.protien.toString()
        var tvSugar = findViewById<TextView>(R.id.tvSugarValue)
        tvSugar.text = fruit?.nutritions?.sugar.toString()
        var tvFat = findViewById<TextView>(R.id.tvFatValue)
        tvFat.text = fruit?.nutritions?.fat.toString()
        var tvCalories = findViewById<TextView>(R.id.tvCaloriesValue)
        tvCalories.text = fruit?.nutritions?.calories.toString()

    }
}