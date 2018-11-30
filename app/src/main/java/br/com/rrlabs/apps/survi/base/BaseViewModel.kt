package br.com.rrlabs.apps.survi.base

import android.arch.lifecycle.ViewModel
import br.com.rrlabs.apps.survi.di.injection.DaggerViewModelInjector
import br.com.rrlabs.apps.survi.di.injection.NetworkModule
import br.com.rrlabs.apps.survi.di.injection.ViewModelInjector
import br.com.rrlabs.apps.survi.ui.product.ProductListViewModel

abstract class BaseViewModel: ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }
    private fun inject (){
        when(this){
            is ProductListViewModel -> injector.inject(this)
        }
    }
}