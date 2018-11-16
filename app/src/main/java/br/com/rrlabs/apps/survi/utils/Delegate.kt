package br.com.rrlabs.apps.survi.utils

import android.app.Activity
import android.support.annotation.LayoutRes
import kotlin.reflect.KProperty

/*
import android.databinding.BaseObservable
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding

fun <R : BaseObservable, T : Any> bindable(
        value: T, bindingRes: Int): BindableDelegate<R, T> {
    return BindableDelegate(value, bindingRes)
}
class BindableDelegate<in R : BaseObservable, T : Any>(
        private var value: T, private val bindingEntry: Int) {
    operator fun getValue(thisRef: R, property: KProperty<*>):
            T = value

    operator fun setValue(thisRef: R, property: KProperty<*>,
                          value: T) {
        this.value = value
        thisRef.notifyPropertyChanged(bindingEntry)
    }
}

*/
/**
 * Funçao responsabel por chamar a classe
 *//*

fun <T : ViewDataBinding> contentView(@LayoutRes layoutRes: Int): SetContentView<T> {
    return SetContentView(layoutRes)
}

*/
/**
 * Classe que retorna o databinding de acordo com o layout recebido.
 *//*

class SetContentView<out T : ViewDataBinding>(
        @LayoutRes private val layoutRes: Int
) {
    private var value: T? = null
    operator fun getValue(thisRef: Activity, property: KProperty<*>): T {
        value = value ?: DataBindingUtil.setContentView(thisRef, layoutRes)
        return value!!
    }
}*/
