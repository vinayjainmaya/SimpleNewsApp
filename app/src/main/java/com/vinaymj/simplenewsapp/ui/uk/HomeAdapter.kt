package com.vinaymj.simplenewsapp.ui.uk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vinaymj.news.headline.domain.model.Article
import com.vinaymj.news.core.utils.OnItemClickListener
import com.vinaymj.simplenewsapp.R
import com.vinaymj.simplenewsapp.databinding.NewsItemBinding

class HomeAdapter(
    private val listener: OnItemClickListener
)
    : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var items: List<Article> = listOf()

    inner class HomeViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.rootLayout.setOnClickListener {}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        val binding by lazy { NewsItemBinding.bind(view) }

        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = items[position]
        holder.binding.newsHeadlines.text = item.title
        item.urlToImage.let { url ->
            Glide.with(holder.binding.root)
                .load(url)
                .override(200, 200)
                .centerCrop()
                .into(holder.binding.imageView)
        }
    }

    override fun getItemCount() = items.size

    internal fun setItem(articles: List<Article>?) {
        articles?.let {
            items = it
        }
    }
}