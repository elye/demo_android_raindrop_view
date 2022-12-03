package com.example.raindrop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.raindrop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    companion object {
        private const val RAINDROP_LIST_STATE = "RaindropListState"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            it.getParcelableArrayList<RainDrop>(RAINDROP_LIST_STATE)?.let {
                binding.rainDropView.rainDropList = it
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (binding.rainDropView.rainDropList.isNotEmpty()) {
            outState.putParcelableArrayList(RAINDROP_LIST_STATE, binding.rainDropView.rainDropList as ArrayList)
        }
    }
}
