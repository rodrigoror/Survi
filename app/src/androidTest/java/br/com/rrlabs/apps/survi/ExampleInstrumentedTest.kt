package br.com.rrlabs.apps.survi

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import br.com.rrlabs.apps.survi.data.model.entities.Client
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest:DBTest() {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("br.com.rrlabs.apps.survi", appContext.packageName)
    }

    @Test
    fun insertAndLoadClientTest(){
        val client01 = Client(
                0,
                "31096547848",
                "Rodrigo Ramos",
                "12988149802",
                "http://pluspng.com/img-png/twitter-logo-png-twitter-logo-png-256.png",
                "https://upload.wikimedia.org/wikipedia/commons/c/c5/Polarlicht_2_kmeans_16_large.png"
        )
        _db!!.clientDao().insert(client01)
        val rClient01 = _db!!.clientDao().getAllOrderById().get(0)
        assertEquals(client01.cpf,rClient01.cpf)
    }



}
