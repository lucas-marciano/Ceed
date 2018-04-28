package com.lucasmarciano.ceep.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasmarciano.ceep.R
import com.lucasmarciano.ceep.model.Post
import kotlinx.android.synthetic.main.post_item.view.*

/**
 * Created by lucasmarciano on 26/04/2018.
 * Nonus
 */
class PostListAdapter(private val posts: List<Post>,
                      private val context: Context) : Adapter<PostListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return posts.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bindView(post)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bindView(post: Post){
            val title = itemView.note_item_title
            val body = itemView.note_item_body

            title.text = post.title
            body.text = post.body.substring(0, 100) + " ... "
        }
    }
}
