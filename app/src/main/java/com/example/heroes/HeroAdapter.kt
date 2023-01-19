package com.example.heroes

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class HeroAdapter(val dataSet: List<Hero>) : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    companion object {
        val EXTRA_HERO = "hero"
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView
        val textViewDesc: TextView
        val textViewRank: TextView
        val layout: ConstraintLayout

        init {
            // Define click listener for the ViewHolder's View
            textViewName = view.findViewById(R.id.textView_heroItem_name)
            textViewDesc = view.findViewById(R.id.textView_heroItem_description)
            textViewRank = view.findViewById(R.id.textView_heroItem_ranking)
            layout = view.findViewById(R.id.layout_heroItem)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_hero, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val hero = dataSet[position]
        viewHolder.textViewName.text = hero.name
        viewHolder.textViewDesc.text = hero.description
        viewHolder.textViewRank.text = hero.ranking.toString()
        viewHolder.layout.setOnClickListener {
            //Toast.makeText(it.context, hero.toString(), Toast.LENGTH_SHORT).show()
            val detailIntent = Intent(it.context, HeroDetailActivity::class.java)
            detailIntent.putExtra(EXTRA_HERO, hero)

            it.context.startActivity(detailIntent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}