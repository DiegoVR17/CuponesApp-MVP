package com.example.cuponesappmvp.model

import com.example.cuponesappmvp.presenter.CuponesPresenter

class CuponesInteractorImpl (cuponesPresenter: CuponesPresenter) : CuponesInteractor {

    private var cuponesRepository: CuponesRepository = CuponesRepositoryImpl(cuponesPresenter)
    override fun loadListCupones() {
        cuponesRepository.loadListCupones()
    }
}