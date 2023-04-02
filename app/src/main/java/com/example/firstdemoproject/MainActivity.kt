package com.example.firstdemoproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.firstdemoproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "OnCreate")

        binding.buttonMain.setOnClickListener {
            val msg = binding.editTextMain.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("msg", msg)
            resultLauncher.launch(intent)

        }

        if (savedInstanceState != null) {
            val isVisible =
            savedInstanceState.getBoolean("reply_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                binding.textHeaderReply.setVisibility(View.VISIBLE)
                val visibleString = savedInstanceState.getString("reply_text")
                binding.textMessageReply.text = visibleString
                binding.textMessageReply.setVisibility(View.VISIBLE);
            }
        }
    }
        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->


                if (result.resultCode == Activity.RESULT_OK) {
                    val data: Intent? = result.data
                    val reply = data?.getStringExtra("reply")
                    binding.textHeaderReply.visibility = View.VISIBLE
                    binding.textMessageReply.visibility = View.VISIBLE
                    binding.textMessageReply.text = reply
                }
            }

        override fun onStart() {
            super.onStart()
            Log.d(TAG, "onStart")
        }

        override fun onPause() {
            super.onPause()
            Log.d(TAG, "onPause")
        }

        override fun onRestart() {
            super.onRestart()
            Log.d(TAG, "onRestart")
        }

        override fun onResume() {
            super.onResume()
            Log.d(TAG, "onResume")
        }

        override fun onStop() {
            super.onStop()
            Log.d(TAG, "onStop")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.d(TAG, "onDestroy")
        }

        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            // If the heading is visible, message needs to be saved.
            // Otherwise we're still using default layout.
            if (binding.textMessageReply.getVisibility() === View.VISIBLE) {
                outState.putBoolean("reply_visible", true)
                outState.putString(
                    "reply_text",
                    binding.textMessageReply.text.toString()
                )
            }
        }
        companion object {
            private const val TAG = "[Ayrin/MainActivity"
        }
    }
