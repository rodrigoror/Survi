package br.com.rrlabs.apps.survi.data.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity
data class Client(
        @PrimaryKey(autoGenerate = true)
        @NonNull
        val id: Int,
        @NonNull
        val cpf: String,
        @NonNull
        val name: String,
        @NonNull
        val contact: String,
        val logoImageURL: String,
        val largeImageURL: String
)