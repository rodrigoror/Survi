package br.com.rrlabs.apps.survi.di.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import br.com.rrlabs.apps.survi.data.local.db.SurviRoomDatabase
import br.com.rrlabs.apps.survi.ui.product.ProductListViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass:Class<T>):T {
        if(modelClass.isAssignableFrom(ProductListViewModel::class.java)){
            val db = Room.databaseBuilder(activity.applicationContext, SurviRoomDatabase::class.java,"posts").build()
            @Suppress("UNCHECKED_CAST")
            return ProductListViewModel()as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}