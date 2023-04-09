package com.example.homework5

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework5.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            var fname = binding.etFname.text?.toString()
            var lname = binding.etLname.text?.toString()
            var email = binding.etEmail.text?.toString()
            var pass = binding.etPass.text?.toString()
            if (fname == null) {
                Toast.makeText(this, "Enter First name!!!", Toast.LENGTH_LONG).show()
            } else {
                if (lname == null)
                    Toast.makeText(this, "Enter Last name!!!", Toast.LENGTH_LONG).show()
                else {
                    if (email == null)
                        Toast.makeText(this, "Enter Email!!!", Toast.LENGTH_LONG).show()
                    else {
                        if (pass == null)
                            Toast.makeText(this, "Enter Password!!!", Toast.LENGTH_LONG).show()
                        else {
                            val rintent = intent // getIntent()

                            rintent.putExtra("newUser", User(fname, lname, email, pass))
                            setResult(Activity.RESULT_OK, rintent)
                            finish()
                        }
                    }
                }
            }
        }

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}