package com.example.shoeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlin.system.exitProcess

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val intent = Intent(this, LoginActivity::class.java)
        val tvLogin: TextView = findViewById(R.id.tv_login)
        val registerButton: Button = findViewById(R.id.registerButton)
        val emailRegister: EditText = findViewById(R.id.emailRegister)
        val passwordRegister: EditText = findViewById(R.id.passwordRegister)

        val firstName: EditText = findViewById(R.id.firstNameRegister)
        val lastName: EditText = findViewById(R.id.lastNameRegister)
        val phoneNumber: EditText = findViewById(R.id.editTextPhone)
        //val confirmPassword: EditText = findViewById(R.id.confirmPasswordRegister)

        tvLogin.setOnClickListener {
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            when {
                TextUtils.isEmpty(firstName.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please enter your first name.", Toast.LENGTH_LONG).show()
                }
            }
            when {
                TextUtils.isEmpty(lastName.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(this, "Please enter your last name.", Toast.LENGTH_LONG).show()
                }
            }
            when {
                TextUtils.isEmpty(phoneNumber.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please enter your phone number.", Toast.LENGTH_LONG).show()
                }
            }
            when {
                TextUtils.isEmpty(emailRegister.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please enter email.", Toast.LENGTH_LONG).show()
                }
            }
            when {
                TextUtils.isEmpty(passwordRegister.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please enter password.", Toast.LENGTH_LONG).show()
                }
                else -> {
                    val email: String = emailRegister.text.toString().trim { it <= ' ' }
                    val password: String = passwordRegister.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(this, "You are registered successfully", Toast.LENGTH_LONG).show()

                                val intent = Intent(this, DashboardActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", firebaseUser.uid)
                                intent.putExtra("email_id", email)
                                startActivity(intent)
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

/*
registerButton.setOnClickListener {
            when {
                TextUtils.isEmpty(emailRegister.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please enter email.", Toast.LENGTH_LONG).show()
                }
            }
            when {
                TextUtils.isEmpty(passwordRegister.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please enter password.", Toast.LENGTH_LONG).show()
                }
                else -> {
                    val email: String = emailRegister.text.toString().trim { it <= ' ' }
                    val password: String = passwordRegister.text.toString().trim { it <= ' '}

                    //Create an instance and create a register a user with email and password
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            // If the registration is successfully done
                            if (task.isSuccessful) {
                                //Firebase Registered User
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this,
                                    "You are registered successfully.",
                                    Toast.LENGTH_LONG
                                ).show()

                                //Automatic Sign IN

                                val intent = Intent(this, MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", firebaseUser.uid)
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            } else {
                                // If the user is not registered successfully
                                Toast.makeText(
                                    this, task.exception!!.message.toString(), Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                }
            }

        }
 */