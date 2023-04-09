package com.example.intentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ShareCompat
import com.example.intentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            var input = binding.msg.text.toString()

            // create intent object
            var m_intent = Intent(this, SecondActivity::class.java)
            //to pass message
            m_intent.putExtra("msg", input)
            // launch second activity
            startActivity(m_intent)
        }


        /* retrieve the result back doing below */
        var resultContract = registerForActivityResult(ActivityResultContract.)
    }

    /*
    * dial up
    * */
//    fun dial(view: View) {
//        val i = intent
//        i.action = Intent.ACTION_DIAL
//        valt et2 = tel.text.toString()
//        i.data = Uri.parse("tel:$et2")
//        startActivity(i)
//    }

    /* implicity intent hiihiin tuld third party app - n package heregtei
        - PackageNameViewer app ashiglaj bolno, esvel playstore - s harna
    */
    fun whatsapp(view: View) {
        var i = packageManager.getLaunchIntentForPackage("com.whatsapp")
        if (i != null)
            startActivity(i)
//        else
            // some msg "whats app not installed"
    }


    /* open web
    * */
    fun openWeb(v: View) {
        var uriText = ""
        val webpage = Uri.parse(uriText)
        val i = Intent(Intent.ACTION_VIEW, webpage)
        if (i.resolveActivity(packageManager) != null) {
            startActivity(i)
        } else {
            // log
        }
    }

    /*
    * open location
    * */
    fun openLocation(v: View) {
        var loc = "walmart near me"
        // lat, lon ogch bolno || q-> query
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val i = Intent(Intent.ACTION_VIEW, addressUri)
        if (i.resolveActivity(packageManager) != null) {
            startActivity(i)
        } else {
            // log
        }
    }

    /* intent filter - send msg implicit (share)*/
    fun share(v: View) {
        var txt = ""
        ShareCompat.IntentBuilder(this)
            .setType("text/plain")
            .setChooserTitle("share with")
            .setText(txt)
            .startChooser()
    }



}