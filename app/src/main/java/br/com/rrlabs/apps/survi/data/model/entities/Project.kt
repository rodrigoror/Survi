package br.com.rrlabs.apps.survi.data.model.entities

import android.arch.persistence.room.*
import android.support.annotation.NonNull

@Entity(/*indices = [Index(name = "productId"), Index(name = "clientId")],*/
        foreignKeys = arrayOf(
        ForeignKey(
            entity = Client::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("client_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),ForeignKey(
            entity = Product::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("product_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
        ))
data class Project(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        @NonNull val active: Boolean,
        /*@TypeConverters(ListConverter::class)
        val products: List<Product>,*/
         @ColumnInfo(name = "product_id") val productId: Int,
         @ColumnInfo(name = "client_id") val clientId: Int,
        @NonNull val name: String
)