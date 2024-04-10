package com.jaycodes.signuppage

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signup = findViewById<Button>(R.id.createAcc)

        signup.setOnClickListener{
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
            Toast.makeText(this,"New Activity Started!!", Toast.LENGTH_SHORT).show()
        }

        Toast.makeText(this,"Login Activity Started!!", Toast.LENGTH_SHORT).show()

    }

}