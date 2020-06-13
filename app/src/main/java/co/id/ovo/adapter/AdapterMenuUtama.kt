package co.id.ovo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.ovo.MenuPembayaranActivity
import co.id.ovo.R
import kotlinx.android.synthetic.main.view_menu_utama.view.*

/**
 * Created by Sainal Sultan on 6/13/2020.
 * sainalsultan@gmail.com | Hasanah Dev.
 */
class AdapterMenuUtama : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val list : MutableList<String> = mutableListOf()
    private val listLontara : MutableList<String> = mutableListOf()

    fun setAdapter(list: MutableList<String>,listLontara: MutableList<String>){
        this.list.clear()
        this.list.addAll(list)
        this.listLontara.clear()
        this.listLontara.addAll(listLontara)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.view_menu_utama,parent,false).also {
            return ViewHolder(it)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            holder.itemView.run{

                /*val marginStart: Int
                val marginEnd: Int
                val marginTop: Int
                val marginBottom: Int

                marginTop = resources.getDimensionPixelSize(R.dimen.marginSpace)
                marginBottom = resources.getDimensionPixelSize(R.dimen.marginSpace)

                if (position == list.size - 1) {
                    marginStart = resources.getDimensionPixelSize(R.dimen.marginSpace)
                } else {
                    marginStart = resources.getDimensionPixelSize(R.dimen.marginSpace)
                }

                if (position == 0) {
                    marginEnd = resources.getDimensionPixelSize(R.dimen.marginSpace)
                } else {
                    marginEnd = 0
                }

                (this.layoutParams as RecyclerView.LayoutParams).also {
                    it.marginStart = marginStart
                    it.marginEnd = marginEnd
                    it.topMargin = marginTop
                    it.bottomMargin = marginBottom
                }*/

                /*textview_lontara_bugis.text = listLontara.get(position)
                textview_lontara_bugis_arti.text = list.get(position)*/
                textview_menu.text = list.get(position)
                setOnClickListener {
                    context.startActivity(Intent(context, MenuPembayaranActivity::class.java))
                }
            }
        }
    }

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
}