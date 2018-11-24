package br.com.rrlabs.apps.survi.data.remote

import br.com.rrlabs.apps.survi.data.model.entities.Client
import br.com.rrlabs.apps.survi.data.model.entities.Product
import br.com.rrlabs.apps.survi.data.model.entities.Project
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("/projects")
    fun getProjects():Observable<List<Project>>

    @GET("/clients")
    fun getClients():Observable<List<Client>>

    @GET("/products")
    fun getProducts():Observable<List<Product>>
}