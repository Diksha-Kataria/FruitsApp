package com.example.fruitapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Fruit(
  var name: String = "",
  var family: String = "",
  var nutritions: Nutrition? = null,
  var genus: String = ""
): Parcelable {

}