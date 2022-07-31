package com.dicoding.githubapp.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubapp.databinding.ItemRowGithubBinding
import com.dicoding.githubapp.model.GithubResponse

class GithubAdapter(private val listGithub : ArrayList<GithubResponse>) : RecyclerView.Adapter<GithubAdapter.ListViewHolder>() {
    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_BIRTH = "extra_birth"
        const val EXTRA_CITY = "extra_city"
        const val EXTRA_photo = "extra_photo"
    }


    class ListViewHolder(var binding: ItemRowGithubBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowGithubBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listGithub[position]

        holder.binding.tvItemName.text = data.name
        holder.binding.imageUser.setImageResource(data.photo)
        holder.binding.tvItemName.setOnClickListener {

            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(EXTRA_USERNAME, data.name)
            intent.putExtra(EXTRA_BIRTH, data.birth)
            intent.putExtra(EXTRA_CITY, data.city)
            intent.putExtra(EXTRA_photo, data.photo)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listGithub.size
}