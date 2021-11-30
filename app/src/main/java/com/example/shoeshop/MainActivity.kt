package com.example.shoeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userId = intent.getStringExtra("user_id")
        val emailId =  intent.getStringExtra("email_id")

        val textViewUserId: TextView = findViewById(R.id.textView_User_Id)
        val textViewUserEmail: TextView = findViewById(R.id.textView_Email)

        textViewUserId.text = "User ID :: $userId"
        textViewUserEmail.text = "Email ID :: $emailId"

        val logOutButton: Button = findViewById(R.id.logOutButton)

        logOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}