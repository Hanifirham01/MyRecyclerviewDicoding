package com.example.barubuat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewHeroAdapter(private val listHero : ArrayList<Hero>): RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): CardViewHeroAdapter.CardViewViewHolder {
        val view :View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_hero,parent,false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val hero = listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgPhoto)

        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail

        holder.itemView.setOnClickListener{ Toast.makeText(holder.itemView.context, "Favorite" + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()}
        holder.btnShare.setOnClickListener { Toast.makeText(holder.itemView.context, "Share" + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()}
        holder.itemView.setOnClickListener{ Toast.makeText(holder.itemView.context, "Kamu Memilih" + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()}
    }
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDetail : TextView = itemView.findViewById(R.id.tv_item_detail)
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
        val btnFavorite : Button = itemView.findViewById(R.id.btn_set_favorite)
        val btnShare : Button = itemView.findViewById(R.id.btn_set_share)
    }
}