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
}