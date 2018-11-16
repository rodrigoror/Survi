package br.com.rrlabs.apps.survi.data.model.repositories

import android.app.Application
import br.com.rrlabs.apps.survi.data.local.db.SurviRoomDatabase
import br.com.rrlabs.apps.survi.data.local.db.dao.ProductDao

class ProductRepository(application: Application){
    private val productDao: ProductDao

    init {
        val db = SurviRoomDatabase.getDatabase(application)
        productDao = db!!.productDao()
    }
}