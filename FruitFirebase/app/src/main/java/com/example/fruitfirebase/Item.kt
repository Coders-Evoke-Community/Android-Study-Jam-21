package com.example.fruitfirebase

class Item {

    // companion object can be called simply by using the class name
    // ex : Item.fruitsType
    companion object{
        const val fruitsType = "Fruits"
        const val vegetablesType = "Vegetables"
        const val othersType = "Others"
    }

    var name : String = ""
    var type : String = ""

}