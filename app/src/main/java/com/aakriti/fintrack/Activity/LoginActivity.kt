package com.aakriti.fintrack.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aakriti.fintrack.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        // Check if user is already logged in
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            // If already logged in, navigate to MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        val emailField: EditText = findViewById(R.id.login_email)
        val passwordField: EditText = findViewById(R.id.login_password)
        val loginButton: Button = findViewById(R.id.login_button)
        val signupRedirect: TextView = findViewById(R.id.signup_redirect)

        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish() // Prevent going back to the login screen
                    } else {
                        Toast.makeText(this, "Login Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        signupRedirect.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}
