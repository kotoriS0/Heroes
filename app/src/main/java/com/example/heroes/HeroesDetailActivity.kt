package com.example.heroes

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heroes.databinding.ActivityHeroesDetailBinding

class HeroesDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeroesDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}