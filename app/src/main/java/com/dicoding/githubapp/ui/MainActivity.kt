package com.dicoding.githubapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubapp.R
import com.dicoding.githubapp.databinding.ActivityMainBinding
import com.dicoding.githubapp.model.GithubResponse

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var rvGithub : RecyclerView
    private val list = ArrayList<GithubResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvGithub = findViewById(R.id.rv_github)
        rvGithub.setHasFixedSize(true)

        list.addAll(listGithub)

        showRecyclerList()
    }

    private val listGithub : ArrayList<GithubResponse>
        get() {
            val dataUsername = resources.getStringArray(R.array.data_username)
            val dataCity = resources.getStringArray(R.array.data_city)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listGithub = ArrayList<GithubResponse>()
            for (i in dataUsername.indices){
                val github = GithubResponse(dataUsername[i], dataCity[i], dataPhoto.getResourceId(i, 0))
                listGithub.add(github)
            }
            return listGithub
        }

    private fun showRecyclerList(){
        rvGithub.layoutManager = LinearLayoutManager(this)

        val githubAdapter = GithubAdapter(list)
        rvGithub.adapter = githubAdapter
    }
}