package br.com.rrlabs.apps.survi.data.model.entities

data class FullProjectItem(val name: String,
                            val projectId: String,
                            val active:Boolean,
                            val projectDescription: String,
                            val clientName: String) {
}
