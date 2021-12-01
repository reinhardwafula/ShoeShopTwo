package com.example.shoeshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val forgotPasswordEmail: EditText = findViewById(R.id.forgot_password_email)
        val submitButton: Button = findViewById(R.id.submit_button)

        submitButton.setOnClickListener {
            when {
                TextUtils.isEmpty(forgotPasswordEmail.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show()
                }
                else -> {
                    val email = forgotPasswordEmail.text.toString()
                    FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                        .addOnCompleteListener { task->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
                                finish()
                            } else {
                                Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                            }
                        }
                }
            }
        }
    }
}