package br.com.rrlabs.apps.survi.utils.Converters

import android.arch.persistence.room.TypeConverter
import java.math.BigInteger
import java.util.*

class DateConverters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}

class BigInteger {
    fun Long.toBigInteger() = BigInteger.valueOf(this)
    fun Int.toBigInteger() = BigInteger.valueOf(toLong())
}