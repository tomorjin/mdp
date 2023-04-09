package com.example.homework5

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val users = arrayListOf(
        User("tomo", "Ari", "tarildii@miu.edu", "pass"),
        User("John", "Doe", "jdoe@miu.edu", "pass1")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        var username = "jdoe@miu.edu"
//        var password = "pass1"

        binding.btnSignin.setOnClickListener {
            var username = binding.etEmail.text.toString()
            var password = binding.etPass.text.toString()
            var loggedUser: User? = checkUser(username, password)
            if (loggedUser != null) {
                var welcomeIntent = Intent(this, WelcomeActivity::class.java)
                welcomeIntent.putExtra("loggedUser", loggedUser)
                startActivity(welcomeIntent)
            } else {
                Toast.makeText(this, "Username and password are incorrect", Toast.LENGTH_LONG)
                    .show()
            }
        }

        var resultNewUser =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                // result object contains the intent and RESULT_OK or RESULT_CANCEL
                if (result.resultCode == Activity.RESULT_OK) {
//                binding.tv.text = result.data?.data.toString()
                    var newUser = result.data?.getSerializableExtra("newUser") as User
                    if (newUser != null) {
                        users.add(newUser)
                        for(u in users)
                            println(u)
                        Toast.makeText(this, "User registered successfully", Toast.LENGTH_LONG)
                            .show()
                    }
                } else
                    Toast.makeText(this, "Failed to register", Toast.LENGTH_LONG).show()
            }

        binding.btnSignup.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            resultNewUser.launch(intent)
        }

        binding.txtForgot.setOnClickListener{
            var mail = binding.etEmail.text.toString()
            for (u in users) {
                if (u.email == mail) {
                    var intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
                    intent.putExtra(Intent.EXTRA_EMAIL, mail)
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Forgotten password")
                    intent.putExtra(Intent.EXTRA_TEXT, "Your password is: ${u.password}")
                    if (intent.resolveActivity(packageManager) != null)
                        startActivity(intent)
                }
            }

        }
    }

    private fun checkUser(username: String, password: String): User? {
        for (u in users) {
            if (u.email == username && u.password == password) return u
        }
        return null
    }
}