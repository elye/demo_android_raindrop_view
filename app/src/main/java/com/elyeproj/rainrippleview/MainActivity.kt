package com.elyeproj.rainrippleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.rain_drop_view

class MainActivity : AppCompatActivity() {

    companion object {
        private const val RAINDROP_LIST_STATE = "RaindropListState"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            it.getParcelableArrayList<RainDrop>(RAINDROP_LIST_STATE)?.let {
                rain_drop_view.rainDropList = it
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (rain_drop_view.rainDropList.isNotEmpty()) {
            outState.putParcelableArrayList(RAINDROP_LIST_STATE, rain_drop_view.rainDropList as ArrayList)
        }
    }
}
