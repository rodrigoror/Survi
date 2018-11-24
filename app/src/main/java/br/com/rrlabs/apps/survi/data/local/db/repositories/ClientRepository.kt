package br.com.rrlabs.apps.survi.data.local.db.repositories

import android.app.Application
import br.com.rrlabs.apps.survi.data.local.db.SurviRoomDatabase
import br.com.rrlabs.apps.survi.data.local.db.dao.ClientDao

/**
 * based on https://android.jlelse.eu/android-architecture-components-now-with-100-more-mvvm-11629a630125
 */
class ClientRepository (application: Application){
    private val clientDao: ClientDao

    init {
        val db = SurviRoomDatabase.getDatabase(application)
        clientDao = db!!.clientDao()
    }

    private val sInstance : ClientRepository? = null

}