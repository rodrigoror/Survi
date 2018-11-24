package br.com.rrlabs.apps.survi.ui.project

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.rrlabs.apps.survi.R
import br.com.rrlabs.apps.survi.data.model.entities.FullProjectItem
import br.com.rrlabs.apps.survi.databinding.ContentMainItemBinding

/**
 *
 */
class FullProjectAdapter : RecyclerView.Adapter<FullProjectAdapter.ViewHolder>() {

    private lateinit var items :  List<FullProjectItem>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding:ContentMainItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.content_main_item,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized)items.size else 0
    }

    override fun onBindViewHolder(p0: FullProjectAdapter.ViewHolder, p1: Int) {
        p0.bind(items[p1])
    }

    fun updateList(list:List<FullProjectItem>){
        this.items = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ContentMainItemBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = FullProjectItemViewModel()

        fun bind(item:FullProjectItem){
            viewModel.bind(item)
            binding.viewModel = viewModel
        }
    }
}