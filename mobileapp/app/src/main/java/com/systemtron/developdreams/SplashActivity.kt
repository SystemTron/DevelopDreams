package com.systemtron.developdreams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.systemtron.developdreams.activities.HomeActivity
import com.systemtron.developdreams.utils.Constants.Companion.splashTAG

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 5000
    private var splashHandler: Handler? = null
    private val mIntentHandler = Runnable {
        if (!isFinishing) {
            Log.d(splashTAG, "From SplashActivity -> AuthActivity")
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d(splashTAG, "Handler initialed")
        splashHandler = Handler();
        splashHandler!!.postDelayed(mIntentHandler, SPLASH_DELAY)
    }

    override fun onDestroy() {
        Log.d(splashTAG, "Handler destroyed")
//        splashHandler!!.removeCallbacks(mIntentHandler)
        super.onDestroy()
    }

}