package br.com.rrlabs.apps.survi.data.local.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import br.com.rrlabs.apps.survi.data.model.entities.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product:Product)

    @Update
    fun update(product: Product)

    @Delete
    fun delete(product: Product)

    @Query("SELECT * FROM product ORDER BY name")
    fun getAll():LiveData<List<Product>>

}