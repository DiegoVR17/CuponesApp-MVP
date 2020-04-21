package com.example.cuponesappmvp.view

import com.example.cuponesappmvp.model.Offer

interface CuponesView {
    fun showErrorLoadCupones(message: String?)
    fun showListCupones(cupones: List<Offer>?)
}