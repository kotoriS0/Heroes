package com.example.heroes

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.heroes.HeroAdapter.Companion.EXTRA_HERO
import com.example.heroes.databinding.ActivityHeroDetailBinding

class HeroDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeroDetailBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = intent?.getParcelableExtra<Hero>(EXTRA_HERO)
        val name = hero?.name
        val description = hero?.description
        val power = hero?.superpower
        val ranking = hero?.ranking
        val image = hero?.image

        binding.textViewHeroDetailName.text = name
        binding.textViewHeroDetailDescription.text = description
        binding.textViewHeroDetailSuperpower.text = power
        binding.textViewHeroDetailRank.text = ranking.toString()
        val resourceId = resources.getIdentifier(image, "drawable", packageName)
        //Toast.makeText(this, resourceId.toString(), Toast.LENGTH_SHORT).show()
        binding.imageViewHeroDetailImage.setImageDrawable(resources.getDrawable(resourceId))
    }
}