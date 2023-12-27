package com.gdsc.doguslive.live

val ageList: ArrayList<Int> = arrayListOf(21,26,47,18,20,25,12,34,34,56)

fun getAgeAverage() {
    var totalAgeCount = 0
    var ageAverage: Float = 0.0f
    ageList.forEach { age ->
        totalAgeCount = totalAgeCount + age
    }

    ageAverage = (totalAgeCount/ ageList.size).toFloat()

    /*
    for (age in ageList) {

    }
     */


    var index: Int = 0

    while (index < 10) {
        println("10'dan küçük olduğu sürece burası çalışır")
        index++
    }
}
