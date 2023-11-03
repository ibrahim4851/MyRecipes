package com.ibrahim.myrecipes.presentation.recipe.createrecipesteps

fun main(){
    var myMap = mutableMapOf<CustomObject, Boolean>()


    val customObjects = listOf(
        CustomObject("Object1", 25),
        CustomObject("Object2", 30),
        CustomObject("Object3", 22),
        CustomObject("Object4", 35),
        CustomObject("Object5", 28),
        CustomObject("Object6", 40),
        CustomObject("Object7", 21)
    )

    myMap[customObjects[0]] = false
    myMap[customObjects[1]] = false
    myMap[customObjects[2]] = false
    myMap[customObjects[3]] = true
    myMap[customObjects[4]] = false
    myMap[customObjects[5]] = false
    myMap[customObjects[6]] = false

    val filteredMap = myMap.filter { (key, value) -> value }
    myMap[filteredMap.keys.first()] = false
    println(myMap.entries)

}

data class CustomObject(val name: String, val age: Int)