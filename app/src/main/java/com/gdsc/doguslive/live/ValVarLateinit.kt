package com.gdsc.doguslive.live

val createdDate: String = "22.02.2021"
var countOfPost: Int = 3

lateinit var messageList: ArrayList<String>

fun setMessageList() {
    messageList = arrayListOf("sdkjb", "hc")
}

fun setCreatedDate() {

    //createdDate = "08.11.2023"
    countOfPost = countOfPost + 1

}