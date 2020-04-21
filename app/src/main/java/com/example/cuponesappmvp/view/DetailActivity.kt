package com.example.cuponesappmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cuponesappmvp.R
import com.example.cuponesappmvp.model.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.cupon_item.view.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val cupon = intent?.getSerializableExtra("cupon") as Offer
        updateUI(cupon)
    }

    private fun updateUI(cupon: Offer) {
        if(!cupon.imageUrl.isNullOrEmpty()){
            Picasso.get().load(cupon.imageUrl).into(iv_picture)
        }
        else{
            Picasso.get().load(R.mipmap.cupon_repuesto_foreground).into(iv_picture)
        }
        tv_store.text = "Store: " + cupon.store
        tv_offer_text.text = "Offer: " + cupon.offerText
        tv_url.text = "Url: " + cupon.url
        tv_status.text = "Status: " + cupon.status
        tv_start_date.text = "Start Date: " + cupon.startDate
        tv_end_date.text = "End Date: " + cupon.endDate
    }
}