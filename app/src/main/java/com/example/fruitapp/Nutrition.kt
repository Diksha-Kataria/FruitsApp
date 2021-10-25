package com.example.fruitapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Nutrition(
    var carbohydrates: Float = 0.0F,
    var protien: Float = 0.0F,
    var fat	: Float = 0.0F,
    var calories: Float = 0.0F,
    var sugar: Float = 0.0F
): Parcelable{
}