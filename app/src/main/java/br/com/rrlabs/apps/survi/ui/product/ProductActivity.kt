package br.com.rrlabs.apps.survi.ui.product

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.com.rrlabs.apps.survi.R
import br.com.rrlabs.apps.survi.databinding.ContentProductBinding

import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ContentProductBinding
    private lateinit var viewModel: ProductListViewModel
    private var errorSnackbar:Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_product)
        setSupportActionBar(toolbar)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_product)

        binding.rvProduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        viewModel = ViewModelProviders.of(this).get(ProductListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer{
            errorMessage ->
                if (errorMessage != null){
                    showError(errorMessage)
                }else{
                    hideError()
                }
        })
        binding.viewModel = viewModel

        addItem.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry,viewModel.errorClickListener)
        errorSnackbar?.show()
    }


}
