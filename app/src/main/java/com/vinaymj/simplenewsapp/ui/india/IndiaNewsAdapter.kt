package com.vinaymj.simplenewsapp.ui.india

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vinaymj.simplenewsapp.R
import com.vinaymj.simplenewsapp.data.model.Article
import com.vinaymj.simplenewsapp.databinding.NewsItemBinding
import com.vinaymj.simplenewsapp.ui.OnItemClickListener

/**
 * Created by vinaymj on 06/10/22.
 */
class IndiaNewsAdapter(
    private val listener: OnItemClickListener
)
    : RecyclerView.Adapter<IndiaNewsAdapter.IndiaNewsViewHolder>() {

    private var items: List<Article> = listOf()

    inner class IndiaNewsViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.rootLayout.setOnClickListener {
//                listener.onItemClick(items[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndiaNewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        val binding by lazy { NewsItemBinding.bind(view) }

        return IndiaNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IndiaNewsViewHolder, position: Int) {
        val item = items[position]
        holder.binding.newsHeadlines.text = item.title
    }

    override fun getItemCount() = items.size

    fun setItem(articles: List<Article>?) {
        articles?.let {
            items = it
        }
    }
}