package com.example.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heroes.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesListActivity : AppCompatActivity() {
    val TAG = "HeroesListActivity"

    private lateinit var binding: ActivityHeroesListBinding
    lateinit var adapter: HeroAdapter

    lateinit var heroList: List<Hero>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputStream = resources.openRawResource(R.raw.heroes)
        val jsonString = inputStream.bufferedReader().use {
            // the last line of the use function is returned
            it.readText()
        }

        val gson = Gson()
        val sType = object : TypeToken<List<Hero>>() {}.type
        heroList = gson.fromJson<List<Hero>>(jsonString, sType)
        Log.d(TAG, "list: $heroList")

        // create adaptor and fill the recycler view
        adapter = HeroAdapter(heroList)
        // tell recyclerView to use that adaptor
        binding.recyclerViewHeroesList.adapter = adapter
        // tell adapter what kind of layout (linear or grid)
        binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)
    }
}