package com.example.postapp.screen.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.R
import com.example.postapp.databinding.CommentItemBinding
import com.example.postapp.model.canon.Comment

class CommentAdapter(var commentList: MutableList<Comment>?)
    : RecyclerView.Adapter<CommentAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(commentList.isNullOrEmpty()){
            return 0
        }
        return commentList!!.size    }

    override fun onBindViewHolder(holder: CommentAdapter.MyViewHolder, position: Int) {
        if(!commentList.isNullOrEmpty()) {
            holder.bindView(commentList!![position])
        }
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding  = CommentItemBinding.bind(view)


        fun bindView(comment: Comment) {
            binding.apply {
                commentNameItemBodyTV.text = comment.name
                commentItemBodyTV.text = comment.body
            }
        }
    }
}