package com.gdsc.doguslive.live.classsamples


class PostSample(val imageUrl: String) { // Post sınıfı yarattık ve constructor kullandık
     val id: String = "12312309"

     fun getPostImageUrl(): String { // Dönüş değerli fonksiyon kullandık.
          return imageUrl
     }

}