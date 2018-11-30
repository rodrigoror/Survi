package br.com.rrlabs.apps.survi.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import br.com.rrlabs.apps.survi.utils.extensions.getParentActivity
import com.squareup.picasso.Picasso

class BindingAdapters {
    companion object {
        @JvmStatic @BindingAdapter("image")
        fun loadImage(imageView: ImageView, imageUrl: String?) {
            Picasso.get().load(imageUrl).into(imageView)
        }
    }
    @BindingAdapter("mutableVisibility")
    fun setMutableVisibility(view:View, visibility:MutableLiveData<Int>?){
        val parentActivity: AppCompatActivity? = view.getParentActivity()
        if(parentActivity != null && visibility != null){
            visibility.observe(parentActivity, Observer { value -> view.visibility = value ?: View.VISIBLE })
        }
    }
}