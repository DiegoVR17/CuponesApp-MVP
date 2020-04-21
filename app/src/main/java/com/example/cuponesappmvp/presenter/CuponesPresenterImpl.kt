package com.example.cuponesappmvp.presenter

import com.example.cuponesappmvp.model.CuponesInteractor
import com.example.cuponesappmvp.model.CuponesInteractorImpl
import com.example.cuponesappmvp.model.Offer
import com.example.cuponesappmvp.view.CuponesView

class CuponesPresenterImpl (var cuponesView: CuponesView): CuponesPresenter {

    private var cuponesInteractor: CuponesInteractor = CuponesInteractorImpl(this)
    override fun loadListCupones() {
        cuponesInteractor.loadListCupones()
    }

    override fun showErrorLoadCupones(message: String?) {
        cuponesView.showErrorLoadCupones(message)
    }

    override fun sendListCupones(cupones: List<Offer>?) {
        cuponesView.showListCupones(cupones)
    }


}