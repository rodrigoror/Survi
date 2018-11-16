package br.com.rrlabs.apps.survi.data.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import java.math.BigInteger

@Entity
data class Client(
        @PrimaryKey(autoGenerate = true)
        @NonNull
        val id: BigInteger,
        @NonNull
        val cpf: String,
        @NonNull
        val name: String,
        @NonNull
        val contact: String,
        val logoImageURL: String,
        val largeImageURL: String
) {
}