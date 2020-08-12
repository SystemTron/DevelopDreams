package com.systemtron.developdreams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 3000
    private var splashHandler: Handler? = null
    private val mIntentHandler = Runnable {
        if (!isFinishing) {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashHandler = Handler();
        splashHandler!!.postDelayed(mIntentHandler, SPLASH_DELAY)
    }

    override fun onDestroy() {
        splashHandler!!.removeCallbacks(mIntentHandler)
        super.onDestroy()
    }
}