package com.example.homework5

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.homework5.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var loggedUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = intent
        loggedUser = intent.getSerializableExtra("loggedUser") as User

        binding.txtEmail.text = loggedUser.email

        binding.ivBook.setOnClickListener {
            Toast.makeText(this, "You have chosen the Books category of shopping", Toast.LENGTH_LONG)
                .show()
        }
        binding.ivClothing.setOnClickListener {
            Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_LONG)
                .show()
        }
        binding.ivOrganic.setOnClickListener {
            Toast.makeText(this, "You have chosen the Organic category of shopping", Toast.LENGTH_LONG)
                .show()
        }
        binding.ivMedicine.setOnClickListener {
            Toast.makeText(this, "You have chosen the Medicine category of shopping", Toast.LENGTH_LONG)
                .show()
        }
    }
}