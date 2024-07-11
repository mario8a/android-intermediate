package com.mario8a.myapplication.ui.horoscope.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mario8a.myapplication.R
import com.mario8a.myapplication.domain.model.HoroscopeInfo

class HoroscopeAdapter(private  var horoscopeList:List<HoroscopeInfo> = emptyList()):
    RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        // crea la instancia del viewHolder
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope,parent, false)
        )
    }

    override fun getItemCount() = horoscopeList.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        // se encarga de decirle al viewHolder lo que tiene que pintar
        holder.render(horoscopeList[position])
    }
}