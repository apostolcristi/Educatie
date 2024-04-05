package com.example.educatie

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewSignIn: TextView
    private lateinit var textViewForgotPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewSignIn = findViewById(R.id.textViewSignIn)
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            // Simulate remote validation using coroutines
            CoroutineScope(Dispatchers.Main).launch {
                val isValid = isValidCredentials(username, password)
                if (isValid) {
                    // Successful login, navigate to the next screen
                    navigateToOverviewPage()
                } else {
                    // Invalid credentials, show an error message
                    showMessage("Invalid credentials. Please try again.")
                }
            }
        }

        textViewSignIn.setOnClickListener {
            // Handle "Sign In" text click, navigate to your next activity
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        textViewForgotPassword.setOnClickListener {
            // Handle "Forgot Your Password?" text click, navigate to ForgotPasswordActivity
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    // Simulate remote validation using coroutines (replace with actual server logic)
    private suspend fun isValidCredentials(username: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            // Simulated delay for network request (replace with actual network call)
            delay(1000)
            // Replace the following line with your server authentication logic
         true
        //username == "user" && password == "password"
        }
    }

    private fun showMessage(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }

    private fun navigateToOverviewPage() {
        // Navigate to the next activity or page
        val intent = Intent(this, OverviewActivity::class.java)
        startActivity(intent)
        // Finish the current activity if you don't want to go back to it on pressing the back button
        finish()
    }
}
