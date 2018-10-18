package com.fanhl.recyclerviewnesteddemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_view_1.view.*

class AdapterBRVAH1 : BaseQuickAdapter<Int, AdapterBRVAH1.ViewHolder>(R.layout.item_view_1) {
    override fun convert(helper: ViewHolder?, item: Int?) {
        helper?.bind(item ?: return)
    }

    inner class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
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
