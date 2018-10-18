package com.fanhl.recyclerviewnesteddemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_view_1.view.*

class AdapterBRVAH1 : RecyclerView.Adapter<AdapterBRVAH1.ViewHolder>() {
    var data = ArrayList<Int>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view_1, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val adapter2 by lazy { Adapter2() }

        init {
            itemView.apply {
                setOnClickListener { this@AdapterBRVAH1.notifyItemChanged(adapterPosition) }
//                recycler_view_2.adapter = adapter2
            }
        }

        fun bind(data: Int) {
            itemView.apply {
                recycler_view_2_container.apply {
                    recycler_view_2_container.visibility = View.VISIBLE

                    removeAllViews()

                    val recyclerView = LayoutInflater.from(context).inflate(R.layout.partial_recycler_view_2, null, false) as RecyclerView

                    addView(recyclerView)

                    recyclerView.adapter = adapter2
                }
            }
        }
    }
}
