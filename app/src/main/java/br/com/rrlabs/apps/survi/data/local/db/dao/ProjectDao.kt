package br.com.rrlabs.apps.survi.data.local.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import br.com.rrlabs.apps.survi.data.model.entities.Client
import br.com.rrlabs.apps.survi.data.model.entities.FullProjectItem
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

    @Query("SELECT pj.name, pj.id, pj.active, pr.description, cl.name " +
            "FROM Project as pj, Client as cl, Product as pr " +
            "Where pj.client_id = cl.id and pj.product_id = pr.id " +
            "ORDER BY pj.id Desc")
    fun getAllListItem() : List<FullProjectItem>

    @Query("SELECT * FROM PROJECT WHERE client_id = :client ORDER BY active desc")
    fun getAllByClient(vararg client: Int): LiveData< List<Project>>

    @Insert
    fun insertAll(vararg projects: Project)
}