package com.example.myrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.myrecyclerview.model.Hero

class GridHeroAdapter(val listHero: ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallBack: OnItemClickCallBack

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GridHeroAdapter.GridViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_grid_hero, p0, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(p0: GridHeroAdapter.GridViewHolder, p1: Int) {
        Glide.with(p0.itemView.context)
            .load(listHero[p1].photo)
            .into(p0.imgPhoto)

        p0.itemView.setOnClickListener { onItemClickCallBack.onItemCLicked( listHero[p1] ) }
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallBack{
        fun onItemCLicked(data: Hero)
    }

}