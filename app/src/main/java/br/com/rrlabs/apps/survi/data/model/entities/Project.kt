package br.com.rrlabs.apps.survi.data.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import java.math.BigInteger

@Entity
data class Project(
        @PrimaryKey(autoGenerate = true)
        @NonNull
        val id: BigInteger,
        @NonNull val active: Boolean,
        @NonNull val lsProduct: List<Product>,
        @NonNull val client: Client,
        @NonNull val name: String
) {
}