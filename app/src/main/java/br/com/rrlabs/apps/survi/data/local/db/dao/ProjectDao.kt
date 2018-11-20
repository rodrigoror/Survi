package br.com.rrlabs.apps.survi.data.local.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import br.com.rrlabs.apps.survi.data.model.entities.Client
import br.com.rrlabs.apps.survi.data.model.entities.Project

@Dao
interface ProjectDao {
    @Insert()
    fun insert(vararg project: Project)

    @Update
    fun update(vararg project: Project)

    @Delete
    fun delete(vararg project: Project)

    @Query("SELECT * FROM Project ORDER BY client_id asc")
    fun getAll() : LiveData<List<Project>>

    @Query("SELECT * FROM PROJECT WHERE client_id = :client ORDER BY active desc")
    fun getAllByClient(vararg client: Int): LiveData< List<Project>>
}