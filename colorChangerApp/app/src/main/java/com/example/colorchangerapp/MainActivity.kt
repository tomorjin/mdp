package com.example.colorchangerapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.colorchangerapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnbgColorChanger.setOnClickListener(View.OnClickListener {
            binding.bg.setBackgroundColor((Math.random() * 16777215).toInt() or (0xFF shl 24))
        })
        binding.imageButton.setOnClickListener(View.OnClickListener {
            binding.imageButton.setBackgroundColor((Math.random() * 16777215).toInt() or (0xFF shl 24))
        })
    }

    // state save hiine
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("count", 3)
//    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
//        super.onRestoreInstanceState(savedInstanceState)
//        if (savedInstanceState != null) {
//            mCount = savedInstanceState.getInt("count")
//            mTextViewCount?.text = mCount.toString()
//        }
//    }
}