package com.example.cleansource

class NewsAdapter {
    class NewsAdapter : ListAdapter<Article, NewsAdapter.NewsViewHolder>(DiffCallback()) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
            val binding = ListItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return NewsViewHolder(binding)
        }

        override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
            val article = getItem(position)
            holder.bind(article)
        }

        class NewsViewHolder(private val binding: ListItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(article: Article) {
                binding.article = article
                binding.executePendingBindings()
            }
        }

        class DiffCallback : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }
        }
    }

}