package com.example.shoeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val intent = Intent(this, RegisterActivity::class.java)
        val tvRegister: TextView = findViewById(R.id.tv_register)

        val tvEmail: TextView = findViewById(R.id.tv_email)
        val tvPassword: TextView = findViewById(R.id.tv_password)

        tvRegister.setOnClickListener {
            startActivity(intent)
        }

        val loginButton: Button = findViewById(R.id.button)

        loginButton.setOnClickListener {
            when {
                TextUtils.isEmpty(tvEmail.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please enter email.", Toast.LENGTH_LONG).show()
                }
            }
            when {
                TextUtils.isEmpty(tvPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please enter password.", Toast.LENGTH_LONG).show()
                } else -> {
                    val email: String = tvEmail.text.toString().trim { it <= ' ' }
                    val password: String = tvPassword.text.toString().trim { it <= ' ' }

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "You are logged in successfully.",Toast.LENGTH_LONG).show()

                            val intent = Intent(this, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            intent.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)
                            intent.putExtra("email_id", email)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            }

        }
        }
    }
}