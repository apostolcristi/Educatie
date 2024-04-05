package com.example.educatie

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    // Callback function for the Signup Button click
    fun onSignupButtonClick(view: View) {
        // Handle signup logic here
        // You can add your code to validate input and perform signup actions

        // After signup, navigate back to the LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Finish the current activity (SignupActivity)
    }

    // Callback function for the "Already have an account? Login" text click
    fun onLoginLinkClick(view: View) {
        // Navigate back to the LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Finish the current activity (SignupActivity)
    }
}
