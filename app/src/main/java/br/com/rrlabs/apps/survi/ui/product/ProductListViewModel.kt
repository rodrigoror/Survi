package br.com.rrlabs.apps.survi.ui.product

import android.arch.lifecycle.MutableLiveData
import android.view.View
import br.com.rrlabs.apps.survi.R
import br.com.rrlabs.apps.survi.base.BaseViewModel
import br.com.rrlabs.apps.survi.data.local.db.dao.ProductDao
import br.com.rrlabs.apps.survi.data.remote.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProductListViewModel(): BaseViewModel() {
    @Inject
    lateinit var productApi:Api

    private lateinit var subscription:Disposable

    val loadingVisibility : MutableLiveData<Int> = MutableLiveData()

    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadlist() }

    init {
        loadlist()
    }
    private fun loadlist(){
        subscription = productApi.getProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveListStart() }
                .doOnTerminate{ onRetrieveListFinish() }
                .subscribe(
                        { onRetrieveListSuccess() },
                        { onRetrieveListError() }
                )
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun onRetrieveListError() {
        errorMessage.value = R.string.post_error_list
    }

    private fun onRetrieveListSuccess() {

    }

    private fun onRetrieveListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }
}