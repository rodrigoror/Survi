package br.com.rrlabs.apps.survi.di.injection

import br.com.rrlabs.apps.survi.ui.project.FullProjectItemViewModel
import br.com.rrlabs.apps.survi.ui.project.FullProjectListViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    fun inject(fullProjectListViewModel: FullProjectListViewModel)
    fun inject(fullProjectItemViewModel: FullProjectItemViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }

}