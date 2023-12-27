package com.gdsc.doguslive.live

val likedPostList: ArrayList<String> = arrayListOf("dogusüni")

fun postList() {
    // dogus üni, istanbul üni ve 34 kişi beğendi

    likedPostList.get(0) // dogusüni
    likedPostList.get(1) // crash olcak

}

var postDescription: String? = null

fun getDescription() {
    postDescription = "açıklama"
    postDescription?.length // crash olmaz
    postDescription!!.length // crash olur
}