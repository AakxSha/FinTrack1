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

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()

        val emailField: EditText = findViewById(R.id.signup_email)
        val passwordField: EditText = findViewById(R.id.signup_password)
        val signupButton: Button = findViewById(R.id.signup_button)
        val loginRedirect: TextView = findViewById(R.id.login_redirect)

        signupButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
                        // Redirect directly to MainActivity after successful signup
                        startActivity(Intent(this, MainActivity::class.java))
                        finish() // Prevent going back to signup screen
                    } else {
                        Toast.makeText(this, "Signup Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        loginRedirect.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
