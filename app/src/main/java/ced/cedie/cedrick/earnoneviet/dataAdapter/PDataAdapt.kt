package ced.cedie.cedrick.earnoneviet.dataAdapter

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import ced.cedie.cedrick.earnoneviet.dataModel.DModel
import ced.cedie.cedrick.earnoneviet.databinding.Layout2Binding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PDataAdapt  (private val context : Context) : RecyclerView.Adapter<PDataAdapt.PHolder>(){

    private var listH = emptyList<DModel>()
    class PHolder(val hBind : Layout2Binding) : RecyclerView.ViewHolder(hBind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PHolder {
        val hBind = Layout2Binding.inflate(LayoutInflater.from(parent.context), parent,false)
        return PHolder(hBind)
    }

    override fun onBindViewHolder(holder: PHolder, position: Int) {
        with(holder){
            with(listH[position]){
                hBind.title.text = this.subtitle
//                hBind.desc.text = this.descriptions
                Glide.with(context)
                    .load(this.image)
                    .apply(RequestOptions.fitCenterTransform())
                    .into(hBind.icon)

//               val dialogM = Dialog(context)
//               dialogM.requestWindowFeature(Window.FEATURE_NO_TITLE)
//               dialogM.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//               dialogM.setContentView()

            } } }

    override fun getItemCount(): Int {
        return listH.size
    }

    fun setPH(setH : List<DModel>){
        this.listH = setH
        notifyDataSetChanged()
    }
}