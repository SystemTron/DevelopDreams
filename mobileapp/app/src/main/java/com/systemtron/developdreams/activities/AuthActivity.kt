package com.systemtron.developdreams.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.systemtron.developdreams.R
import com.systemtron.developdreams.utils.Constants.Companion.authTAG

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        Log.d(authTAG, "SplashActivity -> AuthActivity")

    }

}