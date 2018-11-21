package br.com.rrlabs.apps.survi.data.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.com.rrlabs.apps.survi.data.local.db.dao.ClientDao
import br.com.rrlabs.apps.survi.data.local.db.dao.ProductDao
import br.com.rrlabs.apps.survi.data.local.db.dao.ProjectDao
import br.com.rrlabs.apps.survi.data.model.entities.Client
import br.com.rrlabs.apps.survi.data.model.entities.Product
import br.com.rrlabs.apps.survi.data.model.entities.Project

@Database(entities = arrayOf(Client::class, Product::class, Project::class),version = 1)
//@TypeConverters(Converters::class)
abstract class SurviRoomDatabase : RoomDatabase(){

    companion object {
        private var instance: SurviRoomDatabase? = null

        fun getDatabase(context: Context): SurviRoomDatabase? {
            if (instance == null) {
                synchronized(SurviRoomDatabase::class.java) {
                    //Create the database
                    instance = Room.databaseBuilder(
                                context.applicationContext,
                            SurviRoomDatabase::class.java,
                            "survi_database"
                    ).build()
                }
            }
            return instance
        }
    }

    abstract fun clientDao(): ClientDao
    abstract fun productDao(): ProductDao
    abstract fun projectDao(): ProjectDao

}