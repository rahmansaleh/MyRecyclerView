package com.example.myrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myrecyclerview.model.Hero

class CardViewHeroAdapter(private val listHeros: ArrayList<Hero>) : RecyclerView.Adapter<CardViewHeroAdapter.CardViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_cardview_hero, p0, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeros.size
    }

    override fun onBindViewHolder(p0: CardViewHolder, p1: Int) {
        val(nama, from, photo) = listHeros[p1]

        Glide.with(p0.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350, 350))
            .into(p0.imgPhoto)

        p0.tvName.text = nama
        p0.tvFrom.text = from

        p0.btnFavorite.setOnClickListener { Toast.makeText(p0.itemView.context, "Favorite "+listHeros[p0.adapterPosition].name, Toast.LENGTH_LONG).show() }

        p0.btnShare.setOnClickListener { Toast.makeText(p0.itemView.context, "Share "+listHeros[p0.adapterPosition].name, Toast.LENGTH_LONG).show() }

        p0.itemView.setOnClickListener { Toast.makeText(p0.itemView.context, "Kamu memilih "+listHeros[p0.adapterPosition].name, Toast.LENGTH_LONG).show() }


    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        val btnShare: Button = itemView.findViewById(R.id.btn_set_share)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvFrom: TextView = itemView.findViewById(R.id.tv_item_from)
    }

}