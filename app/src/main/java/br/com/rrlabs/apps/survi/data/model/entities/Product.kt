package br.com.rrlabs.apps.survi.data.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity
data class Product (
        @PrimaryKey(autoGenerate = true)
        @NonNull
        val id : Int,
        @NonNull val name : String,
        val description : String,
        @NonNull val quantity: Int,
        val barcode: String,
        val price : String,
        val price4sell : String
        )