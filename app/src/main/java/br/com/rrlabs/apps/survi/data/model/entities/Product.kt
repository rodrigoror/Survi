package br.com.rrlabs.apps.survi.data.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import java.math.BigDecimal
import java.math.BigInteger

@Entity
data class Product (
        @PrimaryKey(autoGenerate = true)
        @NonNull
        val id : BigInteger,
        @NonNull val name : String,
        val description : String,
        @NonNull val quantity: Int,
        val barcode: String,
        val price : BigDecimal,
        val price4sell : BigDecimal
        ){
}