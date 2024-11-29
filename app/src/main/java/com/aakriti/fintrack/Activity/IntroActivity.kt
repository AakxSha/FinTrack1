package com.aakriti.fintrack.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager.LayoutParams.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aakriti.fintrack.R
import com.aakriti.fintrack.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            FLAG_LAYOUT_NO_LIMITS,
            FLAG_LAYOUT_NO_LIMITS
        )

        binding.startBtn.setOnClickListener {
            Log.d("IntroActivity", "Navigating to MainActivity")
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}