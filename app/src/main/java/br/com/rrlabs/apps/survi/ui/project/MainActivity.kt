package br.com.rrlabs.apps.survi.ui.project

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import br.com.rrlabs.apps.survi.R
import br.com.rrlabs.apps.survi.databinding.ContentMainItemBinding
import br.com.rrlabs.apps.survi.utils.contentView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val binding: ContentMainItemBinding by contentView(R.layout.content_main_item)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
