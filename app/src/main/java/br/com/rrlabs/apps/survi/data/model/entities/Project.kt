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
        public val id: Int,
        @NonNull public  val active: Boolean,
        /*@TypeConverters(ListConverter::class)
        val products: List<Product>,*/
         @ColumnInfo(name = "product_id") public val productId: Int,
         @ColumnInfo(name = "client_id") public val clientId: Int,
        @NonNull public val name: String
)