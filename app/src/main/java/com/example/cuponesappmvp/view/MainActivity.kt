package com.example.cuponesappmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cuponesappmvp.model.ApiService
import com.example.cuponesappmvp.R
import com.example.cuponesappmvp.model.Cupones
import com.example.cuponesappmvp.model.Offer
import com.example.cuponesappmvp.presenter.CuponesPresenter
import com.example.cuponesappmvp.presenter.CuponesPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(), CuponesView {

    private var cuponesPresenter: CuponesPresenter ?= null
    private var listCupones: List<Offer> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.setHasFixedSize(true)

        cuponesPresenter = CuponesPresenterImpl(this)

        getCupones()
    }

    fun getCupones() {
        cuponesPresenter?.loadListCupones()
    }

    override fun showErrorLoadCupones(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun showListCupones(cupones: List<Offer>?) {
        this.listCupones = cupones
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
        val cuponesAdapter = CuponesAdapter(listCupones as ArrayList<Offer>)
        recyclerView.adapter = cuponesAdapter
    }

}