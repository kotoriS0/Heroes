package com.example.heroes

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.heroes.databinding.ActivityHeroDetailBinding

class HeroDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeroDetailBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(HeroAdapter.EXTRA_NAME) ?: ""
        val description = intent.getStringExtra(HeroAdapter.EXTRA_DESC) ?: ""
        val power = intent.getStringExtra(HeroAdapter.EXTRA_POWER) ?: ""
        val ranking = intent.getStringExtra(HeroAdapter.EXTRA_RANK) ?: ""
        val image = intent.getStringExtra(HeroAdapter.EXTRA_IMAGE) ?: ""

        binding.textViewHeroDetailName.text = name
        binding.textViewHeroDetailDescription.text = description
        binding.textViewHeroDetailSuperpower.text = power
        binding.textViewHeroDetailRank.text = ranking
        val resourceId = resources.getIdentifier(image, "drawable", packageName)
        //Toast.makeText(this, resourceId.toString(), Toast.LENGTH_SHORT).show()
        binding.imageViewHeroDetailImage.setImageDrawable(resources.getDrawable(resourceId))
    }
}