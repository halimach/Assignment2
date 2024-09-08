package com.vu.assignment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Set Layout to Login Page
        setContentView(R.layout.login_screen)
        //Set Button to go to dashboard
        val loginButton: Button = findViewById(R.id.button)
        loginButton.setOnClickListener {
            val usernameEditText = findViewById<EditText>(R.id.usernames)
            val username = usernameEditText.text.toString()
            val passwordEditText = findViewById<EditText>(R.id.passwords)
            val password = passwordEditText.text.toString()

            if (username.isBlank() || password.isBlank()) {
                // Show error message for empty fields
                return@setOnClickListener
            }
            // Show progress bar and disable login button
            val progressBar = findViewById<ProgressBar>(R.id.progressBar)
            progressBar.visibility = View.VISIBLE
            loginButton.isEnabled = false
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            //Pass the username & password with intent
            intent.putExtra("USERNAME", username)
            intent.putExtra("PASSWORD", password)

        }

        //Make the POST Request
        //IDK HOW TO DO THIS YETTTT

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_screen)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}