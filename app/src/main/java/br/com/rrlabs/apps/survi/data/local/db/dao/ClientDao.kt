package br.com.rrlabs.apps.survi.data.local.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import br.com.rrlabs.apps.survi.data.model.entities.Client

@Dao
interface ClientDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(client: Client)

    @Update
    fun update(client: Client)

    @Delete
    fun delete(client: Client)

    @Query("SELECT * FROM Client ORDER BY name")
    fun getAll():LiveData<List<Client>>

    @Query("SELECT * FROM Client ORDER BY id")
    fun getAllOrderById():List<Client>


}