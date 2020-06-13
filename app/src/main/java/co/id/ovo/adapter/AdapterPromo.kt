package co.id.ovo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.ovo.R
import kotlinx.android.synthetic.main.item_promo.view.*


/**
 * Created by Sainal Sultan on 6/13/2020.
 * sainalsultan@gmail.com | Hasanah Dev.
 */
class AdapterPromo : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val list : MutableList<String> = mutableListOf()
    private val randomAndroidColor : MutableList<Int> = mutableListOf()

    fun setAdapter(list: MutableList<String>, randomAndroidColor: MutableList<Int>){
        this.list.clear()
        this.list.addAll(list)
        this.randomAndroidColor.clear()
        this.randomAndroidColor.addAll(randomAndroidColor)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_promo,parent,false).also {
            return ViewHolder(it)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            holder.itemView.run{

                val marginStart: Int
                val marginEnd: Int
                val marginTop: Int
                val marginBottom: Int

                marginTop = resources.getDimensionPixelSize(R.dimen.marginSpace)
                marginBottom = resources.getDimensionPixelSize(R.dimen.marginSpace)

                if (position == list.size - 1) {
                    marginEnd = resources.getDimensionPixelSize(R.dimen.marginLayout)
                } else {
                    marginEnd = resources.getDimensionPixelSize(R.dimen.marginSpace)
                }

                if (position == 0) {
                    marginStart = resources.getDimensionPixelSize(R.dimen.marginLayout)
                } else {
                    marginStart = 0
                }

                (this.layoutParams as RecyclerView.LayoutParams).also {
                    it.marginStart = marginStart
                    it.marginEnd = marginEnd
                    it.topMargin = marginTop
                    it.bottomMargin = marginBottom
                }

//                val colorRandom = context.resources.obtainTypedArray(R.arrays.colorRandom)
//                var randomColor = Random.nextInt(colorRandom.length())
//                imageview_bg_promo.setImageResource()
                /*textview_lontara_bugis.text = listLontara.get(position)
                textview_lontara_bugis_arti.text = list.get(position)*/
                imageview_bg_promo.setBackgroundColor(randomAndroidColor.get(position))
            }
        }
    }

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
}