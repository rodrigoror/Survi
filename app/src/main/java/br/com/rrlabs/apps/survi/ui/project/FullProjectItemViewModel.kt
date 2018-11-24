package br.com.rrlabs.apps.survi.ui.project

import android.arch.lifecycle.MutableLiveData
import br.com.rrlabs.apps.survi.base.BaseViewModel
import br.com.rrlabs.apps.survi.data.model.entities.FullProjectItem

class FullProjectItemViewModel: BaseViewModel(){
    private val name= MutableLiveData<String>()
    private val clientName= MutableLiveData<String>()
    private val projectId= MutableLiveData<String>()
    private val active= MutableLiveData<Boolean>()
    private val projectDescription= MutableLiveData<String>()

    fun bind(item: FullProjectItem){
        name.value = item.name
        clientName.value = item.clientName
        projectId.value = item.projectId
        active.value = item.active
        projectDescription.value = item.projectDescription
    }

    fun getName(): MutableLiveData<String> {return name}
    fun getClientName(): MutableLiveData<String> {return clientName}
    fun getProjectId(): MutableLiveData<String> {return projectId}
    fun getActive(): MutableLiveData<Boolean> {return active}
    fun getProjectDescription(): MutableLiveData<String> {return projectDescription}

}