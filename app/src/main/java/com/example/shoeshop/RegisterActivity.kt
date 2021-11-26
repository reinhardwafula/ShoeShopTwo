package com.example.shoeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val intent = Intent(this, LoginActivity::class.java)
        val tvLogin: TextView = findViewById(R.id.tv_login)

        tvLogin.setOnClickListener {
            startActivity(intent)
        }
    }
}