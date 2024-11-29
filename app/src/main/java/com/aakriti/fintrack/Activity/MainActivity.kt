package com.aakriti.fintrack.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aakriti.fintrack.Adapter.ExpenseListAdapter
import com.aakriti.fintrack.R
import com.aakriti.fintrack.ViewModel.MainViewModel
import com.aakriti.fintrack.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import eightbitlab.com.blurview.RenderScriptBlur

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check if user is logged in
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser == null) {
            // If not logged in, navigate to LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // Prevent going back to this activity
        } else {
            // User is logged in, proceed with MainActivity
            Log.d("MainActivity", "MainActivity started")
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Set full-screen mode
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )

            // Initialize RecyclerView and Blue Effect
            initRecyclerview()
            setBlueEffect()
        }
    }

    private fun setBlueEffect() {
        val radius = 10f
        val decorView = this.window.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackground = decorView.background
        binding.blueView.setupWith(
            rootView,
            RenderScriptBlur(this)
        )
            .setFrameClearDrawable(windowBackground)
            .setBlurRadius(radius)

        binding.blueView.setOutlineProvider(ViewOutlineProvider.BACKGROUND)
        binding.blueView.setClipToOutline(true)
    }

    private fun initRecyclerview() {
        binding.view1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.view1.adapter = ExpenseListAdapter(mainViewModel.loadExpenseData())
        binding.view1.isNestedScrollingEnabled = false
    }
}
