package com.example.shoeshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf<Image>(
            Image("Airmax 270", R.drawable.shoeone, "Kes.2000", "Casual"),
            Image("Air Jordan Red", R.drawable.shoetwo, "Kes.2500", "Casual"),
            Image("Jordan Low Kart Blue", R.drawable.shoethree, "Kes.2500", "Casual"),
            //Image("Jordan 4 Low Kart Blue", R.drawable.shoefour),
            Image("Vans Maroon", R.drawable.shoefive, "Kes.1000", "Casual")

        )

        val recyclerView = findViewById<RecyclerView>(R.id.imagesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, images)

        val userId = intent.getStringExtra("user_id")
        val emailId =  intent.getStringExtra("email_id")

//        val textViewUserId: TextView = findViewById(R.id.textView_User_Id)
//        val textViewUserEmail: TextView = findViewById(R.id.textView_Email)

//        textViewUserId.text = "User ID :: $userId"
//        textViewUserEmail.text = "Email ID :: $emailId"

        val logOutButton: Button = findViewById(R.id.logOutButton)

        logOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        doubleBackToExit()
    }
}