package com.example.contacts.ui


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.contacts.R


class ContactProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //get values from intent
        val extras = intent.extras?.getInt("picture")
        val name_update = intent.getStringExtra("text")
        val phoneUpdate = intent.getStringExtra("phoneNumber")
        val emailImported = intent.getStringExtra("emailCode")

        //reference to view
        val image: ImageView = findViewById(R.id.image_second_layout)
        val text = findViewById<TextView>(R.id.second_activity_text)
        val phone = findViewById<TextView>(R.id.phone)
        val email = findViewById<TextView>(R.id.email_address)
        val backArrow = findViewById<View>(R.id.back_arrow)

        //set value to views
        if (extras != null){
            image.setImageResource(extras)
        }
        text.text = name_update
        phone.text = phoneUpdate
        email.text = emailImported



        backArrow.setOnClickListener {
            onBackPressed()
        }

    }
}