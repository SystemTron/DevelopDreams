package com.systemtron.developdreams.auth

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.systemtron.developdreams.R
import com.systemtron.developdreams.utils.Constants.Companion.authTAG

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        Log.d(authTAG, "SplashActivity -> AuthActivity")

    }

}