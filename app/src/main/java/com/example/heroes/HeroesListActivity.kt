package com.example.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heroes.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesListActivity : AppCompatActivity() {
    val TAG = "HeroesListActivity"

    private lateinit var binding: ActivityHeroesListBinding
    lateinit var adapter: HeroAdapter

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
        var heroList = gson.fromJson<List<Hero>>(jsonString, sType)
        Log.d(TAG, "list: $heroList")

        heroList = heroList.sorted()

        // create adaptor and fill the recycler view
        adapter = HeroAdapter(heroList)
        // tell recyclerView to use that adaptor
        binding.recyclerViewHeroesList.adapter = adapter
        // tell adapter what kind of layout (linear or grid)
        binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.sort_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuItem_name -> {
                adapter.dataSet = adapter.dataSet.sortedBy { it.name }
                adapter.notifyDataSetChanged()
                true
            }
            R.id.menuItem_rank -> {
                adapter.dataSet = adapter.dataSet.sorted()
                adapter.notifyDataSetChanged()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}