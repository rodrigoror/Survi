package br.com.rrlabs.apps.survi.data.local.db.repositories

import android.app.Application
import br.com.rrlabs.apps.survi.data.local.db.SurviRoomDatabase
import br.com.rrlabs.apps.survi.data.local.db.dao.ProjectDao

class ProjectRepository(application: Application){
    private val projectDao: ProjectDao

    init {
        val db = SurviRoomDatabase.getDatabase(application)
        projectDao = db!!.projectDao()
    }
}