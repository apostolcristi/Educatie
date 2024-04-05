package com.example.educatie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
    }

    // Callback function for the Reset Password Button click
    fun onResetPasswordButtonClick(view: View) {
        // Handle reset password logic here
        // You can add your code to validate the email and send a password reset email
    }

    // Callback function for the "Remember your password? Login" link click
    fun onLoginLinkClickForgotPassword(view: View) {
        // Navigate back to the login page
        finish()
    }
}
