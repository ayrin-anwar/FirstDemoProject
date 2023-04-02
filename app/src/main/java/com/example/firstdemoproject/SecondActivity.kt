package com.example.firstdemoproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.PackageManagerCompat.LOG_TAG
import com.example.firstdemoproject.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG,"OnCreate")
        val msg = intent.getStringExtra("msg")
        binding.textMessage.text = msg

        binding.buttonSecond.setOnClickListener {
            val reply = binding.editTextSecond.text.toString()
            val replyIntent = Intent()
            replyIntent.putExtra("reply", reply)
            setResult(RESULT_OK, replyIntent)
            finish()
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
    companion object {
        private const val TAG = "[Ayrin/SecondActivity"
    }
}