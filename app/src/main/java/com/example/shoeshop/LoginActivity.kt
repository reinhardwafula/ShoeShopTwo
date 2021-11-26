package com.example.shoeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val intent = Intent(this, RegisterActivity::class.java)
        val tvRegister: TextView = findViewById(R.id.tv_register)

        tvRegister.setOnClickListener {
            startActivity(intent)
        }
    }
}