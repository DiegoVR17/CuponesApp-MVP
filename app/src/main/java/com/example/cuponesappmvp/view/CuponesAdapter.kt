package com.example.cuponesappmvp.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.example.cuponesappmvp.R
import com.example.cuponesappmvp.model.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cupon_item.view.*

class CuponesAdapter(cuponesList: ArrayList<Offer>) :
    RecyclerView.Adapter<CuponesAdapter.CuponesViewHolder>(){

    private var cuponesList = ArrayList<Offer>()

    init {
        this.cuponesList = cuponesList
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CuponesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.cupon_item,
            parent,false)
        return CuponesViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int = cuponesList.size

    override fun onBindViewHolder(holder: CuponesViewHolder, position: Int) {
        val cupon = cuponesList[position]
        holder.setCupon(cupon)
    }

    class CuponesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{

        private var cupon: Offer ?= null

        init {
            itemView.setOnClickListener(this)
        }

        fun setCupon(cupon: Offer){
            this.cupon = cupon
            itemView.tv_titulo.text = cupon.title
            itemView.tv_categoria.text = "Categories: " +  cupon.categories
            itemView.tv_description.text = "Description: " + cupon.description

            if (!cupon.imageUrl.isNullOrEmpty()){
                Picasso.get().load(cupon.imageUrl).into(itemView.iv_picture)
            }
            else{
                Picasso.get().load(R.mipmap.cupon_repuesto_foreground).into(itemView.iv_picture)
            }

        }

        override fun onClick(v: View?) {
            val intent = Intent(itemView.context,
                DetailActivity::class.java)
            intent.putExtra("cupon",cupon)
            itemView.context.startActivity(intent)
        }
    }

}