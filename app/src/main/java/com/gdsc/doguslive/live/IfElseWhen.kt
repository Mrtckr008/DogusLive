package com.gdsc.doguslive.live


fun checkWeather() {
    val temperature: Int = 17
    val humidity: Int = 60

    if (temperature > 20 || humidity > 80) {

    }


    if (temperature > 20) {
        println("Hava sıcak")
    }
    else if(temperature > 0) {
        println("Hava ılık")
    }
    else {
        println("Hava soğuk")
    }

    val followerCount: Int = 4000

    when(followerCount) {
        in 0..1000 -> {
            println("takipçi sayını geliştir")
        }
        in 1000 .. 10000 -> {
            println("takipçi sayın fena değil")
        }
    }

}