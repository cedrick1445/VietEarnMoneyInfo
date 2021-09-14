package ced.cedie.cedrick.earnoneviet.dataAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ced.cedie.cedrick.earnoneviet.dataModel.DModel
import ced.cedie.cedrick.earnoneviet.databinding.Layout1Binding

class DataAdapter: RecyclerView.Adapter<DataAdapter.DataHolder>() {

    private var dList = emptyList<DModel>()

    class DataHolder (val adBind : Layout1Binding) : RecyclerView.ViewHolder(adBind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val adBind = Layout1Binding.inflate(LayoutInflater.from(parent.context), parent,false)
        return DataHolder(adBind)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        with(holder){
            with(dList[position]){
                adBind.title.text = this.subtitle
                adBind.desc.text = this.descriptions
            }
        }
    }

    override fun getItemCount(): Int {
        return dList.size
    }

    fun setData(setD : List<DModel>){
        this.dList = setD
        notifyDataSetChanged()
    }
}