package com.example.cuponesappmvp.presenter

import com.example.cuponesappmvp.model.Offer

interface CuponesPresenter {
    fun loadListCupones()
    fun showErrorLoadCupones(message: String?)
    fun sendListCupones(cupones: List<Offer>?)
}