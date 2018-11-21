package br.com.rrlabs.apps.survi

import android.arch.core.executor.testing.CountingTaskExecutorRule
import android.content.Context
import android.support.test.InstrumentationRegistry
import br.com.rrlabs.apps.survi.data.local.db.SurviRoomDatabase
import org.junit.Before
import org.junit.Rule

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import org.junit.After
import java.util.concurrent.TimeUnit

abstract class DBTest {
    @Rule
    @JvmField
    val countingTaskExecutorRule = CountingTaskExecutorRule()
    var _db : SurviRoomDatabase? = null

    @Before
    fun initDB() {

        _db = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                SurviRoomDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    fun closeDB(){
        countingTaskExecutorRule.drainTasks(10, TimeUnit.SECONDS)
        _db!!.close()
    }


}