package com.example.intentapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // retrieve an intent
        var r_intent = intent   // Intent r_intent = getIntent() in java
        binding.rmsg.text = intent.getStringExtra("msg")

        var user = Person("fname", "lname", "test")
        var u_intent = Intent(this, ThirdActivity::class.java)
        u_intent.putExtra("user", user)



        /* retrieve the result back doing below */
        binding.textView.setOnClickListener{
            var result = ""

            var i = intent
            i.data = Uri.parse(result)
            setResult(Activity.RESULT_OK, i)
            finish()
        }
    }
}