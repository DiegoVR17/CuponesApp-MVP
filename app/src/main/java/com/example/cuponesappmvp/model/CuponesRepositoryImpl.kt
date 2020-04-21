package com.example.cuponesappmvp.model

import com.example.cuponesappmvp.presenter.CuponesPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CuponesRepositoryImpl (var cuponesPresenter: CuponesPresenter) : CuponesRepository {
    override fun loadListCupones() {
        val apiKey = "c523559828cd8f5fe5df12f99d5c2413"

        ApiService.create()
            .getOffers(apiKey)
            .enqueue(object : Callback<Cupones>{
                override fun onFailure(call: Call<Cupones>, t: Throwable) {
                    cuponesPresenter.showErrorLoadCupones(t.message)
                }

                override fun onResponse(call: Call<Cupones>, response: Response<Cupones>) {
                    if (response.isSuccessful){
                        cuponesPresenter.sendListCupones(response.body()?.offers)
                    }
                }

            })
    }
}