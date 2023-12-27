package com.gdsc.doguslive

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val context: Context, private val dataList: List<Int>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private val descriptionList: ArrayList<String> = arrayListOf("From beautiful view", "Amazing!!", "That's the heaven")
    private val likedPostList: ArrayList<Int> = arrayListOf()
    private var likeCounter: Int = 124

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postImage: ImageView = itemView.findViewById(R.id.postImage)
        val postDescription: TextView = itemView.findViewById(R.id.description)
        val postLikeButton: ImageView = itemView.findViewById(R.id.likeIcon)
        val likeCounter: TextView = itemView.findViewById(R.id.likeCounter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postImage.setImageDrawable(context.resources.getDrawable(dataList.get(position), null))
        holder.postDescription.text = descriptionList.get(position)
        holder.postLikeButton.setOnClickListener { imageView ->
            likePost(imageView as ImageView, position)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    private fun likePost(imageView: ImageView, position: Int) { // Like butonuna basınca çalışcak fonksiyon.
        if (likedPostList.contains(position)) { // likedPostList [0,1] position -> 2 = false -- beğenilmiş indexler ile position'ı kontrol ediyoruz.
              // tıklanmış like'a yeniden tıkladık.                                  // likedPostList [0,1] position -> 1 = true
            imageView.setImageDrawable(context.resources.getDrawable(R.drawable.baseline_favorite_border_24, null))
            likedPostList.remove(position)
            // daha önceden beğenilmiş ise beğenilerden çekiyoruz. (Listeden sil ve resmi varsayılan resim yap)
        }
        else {
            imageView.setImageDrawable(context.resources.getDrawable(R.drawable.ic_hearth, null))
            likedPostList.add(position)
            // daha önceden beğenilmemiş ise beğeni davranışını uyguluyoruz. (Listeye ekle ve resmi beğeni resmi yap)
        }

    }
}
