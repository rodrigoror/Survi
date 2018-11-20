package br.com.rrlabs.apps.survi.utils.Converters

import android.arch.persistence.room.TypeConverter
import br.com.rrlabs.apps.survi.data.model.entities.Product
import java.util.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverter {
    var gson = Gson()

    @TypeConverter
    fun fromTimestamp(data: String?): List<Product>? {

        if (data == null){
            return Collections.emptyList()
        }
        val listType = object : TypeToken<ArrayList<String>>() {}.type
        return gson.fromJson(data, listType)


    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Product>?): String? {
        return gson.toJson(someObjects)
    }


}