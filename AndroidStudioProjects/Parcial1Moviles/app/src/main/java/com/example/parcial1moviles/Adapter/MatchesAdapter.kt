package com.example.parcial1moviles.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1moviles.Entities.Matches
import com.example.parcial1moviles.R
import kotlinx.android.synthetic.main.recyclermatches.view.*

class MatchesAdapter (val click: (Matches) -> Unit) : RecyclerView.Adapter<MatchesAdapter.ViewHolder>(){

    private var matches = emptyList<Matches>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (item: Matches, click: (Matches) -> Unit) = with(itemView){
            teama.text = item.team1
            teamb.text = item.team2
            winner.text = item.winner
            this.setOnClickListener {
                click(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclermatches, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(holder: MatchesAdapter.ViewHolder, position: Int) = holder.bind(matches[position], click)

    internal fun setMatches(matches: List<Matches>){
        this.matches = matches
        notifyDataSetChanged()
    }

}