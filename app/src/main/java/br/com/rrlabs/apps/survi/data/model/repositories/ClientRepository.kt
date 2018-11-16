package br.com.rrlabs.apps.survi.data.model.repositories

import android.app.Application
import br.com.rrlabs.apps.survi.data.local.db.SurviRoomDatabase
import br.com.rrlabs.apps.survi.data.local.db.dao.ClientDao

class ClientRepository (application: Application){
    private val clientDao: ClientDao

    init {
        val db = SurviRoomDatabase.getDatabase(application)
        clientDao = db!!.clientDao()
    }
}