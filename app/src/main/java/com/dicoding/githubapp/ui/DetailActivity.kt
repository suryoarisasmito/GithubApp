package com.dicoding.githubapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.githubapp.R
import com.dicoding.githubapp.databinding.ActivityDetailBinding
import com.dicoding.githubapp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tUsername = intent.getStringExtra("extra_username")
        val tBirth = intent.getStringExtra("extra_birth")
        val tCity = intent. getStringExtra("extra_city")
        val tPhoto = intent.getIntExtra("extra_photo", 0)

        binding.tvSetname.text = tUsername
        binding.tvSetbirth.text = tBirth
        binding.tvSetkota.text = tCity
        binding.imgSetUserPhoto.setImageResource(tPhoto)
    }
}