package com.fanhl.recyclerviewnesteddemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adapter1 by lazy { Adapter1() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipe_refresh_layout.setOnRefreshListener { refreshData() }
        recycler_view_1.adapter = adapter1

        refreshData()
    }

    private fun refreshData() {
        swipe_refresh_layout.postDelayed({
            swipe_refresh_layout.isRefreshing = false
            adapter1.data = arrayListOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2)
        }, 1000)
    }
}
