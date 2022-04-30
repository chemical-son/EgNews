package com.chemical_son.retrofit.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chemical_son.retrofit.R
import com.chemical_son.retrofit.actrivitys.MoreActivity
import com.chemical_son.retrofit.dataModel.Article
import com.chemical_son.retrofit.dataModel.TopHeadlinesResponse

class PostsAdapter(val context: Context, private val data: List<Article>) :
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.item_text)
        val image: ImageView = itemView.findViewById(R.id.item_image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsAdapter.ViewHolder, position: Int) {
        holder.title.text = data[position].title
        Glide.with(context).load(data[position].urlToImage).centerCrop().into(holder.image)
        holder.itemView.setOnClickListener{
            var intent = Intent(context, MoreActivity::class.java)
            intent.putExtra("url", data[position].url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


}