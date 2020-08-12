package com.systemtron.developdreams.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ironclad.snat.SnatToast
import com.systemtron.developdreams.R
import com.systemtron.developdreams.utils.Constants.Companion.authTAG
import com.systemtron.developdreams.utils.Constants.Companion.googleRequestCode
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {

    //lateinit vars
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        Log.d(authTAG, "SplashActivity -> AuthActivity")

        btnAuthGithub.setOnClickListener {
            SnatToast.toastDefault(this, "Selected GitHub", 0)
            Log.d(authTAG, "Selected GitHub")
        }
        btnAuthGoogle.setOnClickListener {
            SnatToast.toastDefault(this, "Selected Google", 0)
            authByGoogle()
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .requestProfile()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        auth = Firebase.auth
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == googleRequestCode) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                Log.d(authTAG, "Account ID: ${account.id}")
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Log.e(authTAG, "Google Auth Failed $e")
            }
        }

    }

    private fun firebaseAuthWithGoogle(token: String) {
        val credential = GoogleAuthProvider.getCredential(token, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d(authTAG, "Google SignIn Successful")
                    runOnUiThread {
                        SnatToast.toastDefault(this, "Google Sign-In Complete", 0)
                    }
                } else {
                    Log.d(authTAG, "Google SignIn Failed")
                    runOnUiThread {
                        SnatToast.toastDefault(this, "Google Sign-In Failed", 0)
                    }
                }
            }.addOnFailureListener {
                Log.d(authTAG, "Google SignIn Failed")
                runOnUiThread {
                    SnatToast.toastDefault(this, "Google Sign-In Failed", 0)
                }
            }
    }

    private fun authByGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, googleRequestCode)
    }
}