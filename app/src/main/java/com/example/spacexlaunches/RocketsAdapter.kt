package com.example.spacexlaunches

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexlaunches.data.Rockets
import com.example.spacexlaunches.databinding.ViewRocketsBinding

class RocketsAdapter : RecyclerView.Adapter<RocketsAdapter.ViewHolder>() {

    private val rockets = mutableListOf<Rockets>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewRocketsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return rockets.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.rocketName = rockets[position].rocketName
        holder.binding.rocketName = rockets[position].country
        holder.binding.rocketName = rockets[position].engines.number.toString()
    }


    class ViewHolder(itemView: ViewRocketsBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        val binding: ViewRocketsBinding = itemView
    }

}