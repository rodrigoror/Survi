package br.com.rrlabs.apps.survi.ui.project

import android.arch.lifecycle.MutableLiveData
import android.view.View
import br.com.rrlabs.apps.survi.R
import br.com.rrlabs.apps.survi.base.BaseViewModel
import br.com.rrlabs.apps.survi.data.local.db.dao.ProjectDao
import br.com.rrlabs.apps.survi.data.model.entities.FullProjectItem
import br.com.rrlabs.apps.survi.data.model.entities.Project
import br.com.rrlabs.apps.survi.data.remote.Api
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FullProjectListViewModel(private val projectDao: ProjectDao):BaseViewModel() {
    @Inject
    lateinit var listApi: Api

    private lateinit var subscription: Disposable

    val loadingVisibility : MutableLiveData<Int> = MutableLiveData()

    val errorMessage: MutableLiveData<Int> = MutableLiveData()

    val errorClickListener = View.OnClickListener { load() }

    val listAdapter: FullProjectAdapter = FullProjectAdapter()

    init {
        load()
    }

    private fun load() {
        //subscription = postApi.getPosts()
        subscription = Observable.fromCallable { projectDao.getAllListItem() }
                .concatMap {
                    dbList ->
                    //if (dbList.isEmpty())
                        listApi.getProjects().concatMap {
                            apiList -> projectDao.insertAll(*apiList.toTypedArray())
                            Observable.just(apiList)
                        }// else Observable.just(dbList)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveListStart() }
                .doOnTerminate { onRetrieveListFinish() }
                .subscribe(
                        {result -> onRetrieveListSuccess(g(result))},
                        {onRetrievePostListError()}
                )
    }

    /**
     *
     */

    private fun g(result: List<Project>?): List<FullProjectItem> {
        var fullProjectList: MutableList<FullProjectItem>?  = null
        for (item in result!!) {
            val act = item.active
            val pId = item.id
            val name = item.name
            val productId = item.productId
            val clientId = item.clientId
            val fullProjectItem =  FullProjectItem(name,pId.toString(),act,"Description "+pId+" "+productId, getClientNameById(clientId))
            fullProjectList?.add(fullProjectItem)
        }
        return fullProjectList!!
    }

    private fun getClientNameById(clientId: Int): String {
        return "Nome do Cliente "+clientId
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.post_error
    }

    private fun onRetrieveListSuccess(postList:List<FullProjectItem>) {
        listAdapter.updateList(postList)
    }

    private fun onRetrieveListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}