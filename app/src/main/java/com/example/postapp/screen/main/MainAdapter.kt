package com.example.postapp.screen.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.R
import com.example.postapp.databinding.PostItemBinding
import com.example.postapp.model.canon.Post

class MainAdapter (var postList: MutableList<Post>?,
                   val itemClicked: OnItemClicked
) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    interface OnItemClicked {
        fun itemClicked(post: Post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(postList.isNullOrEmpty()){
            return 0
        }
        return postList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if(!postList.isNullOrEmpty()) {
            holder.bindView(postList!![position])
        }
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val binding  = PostItemBinding.bind(view)

        init{
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            postList?.get(adapterPosition)?.let { itemClicked.itemClicked(it) }
        }

        fun bindView(post: Post) {
            binding.apply {
                titleTextView.text = post.title
            }
        }
    }
}