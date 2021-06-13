package fr.taigaprozz.kanjikana.account

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import fr.taigaprozz.R
import fr.taigaprozz.databinding.ActivityLoginBinding.inflate
import fr.taigaprozz.kanjikana.GlobalFunctions
import fr.taigaprozz.kanjikana.main.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var mGoogleSignIn: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // no animation when activity is changed
        GlobalFunctions.setNoAnimation(this)
        // view binding
        val binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = FirebaseAuth.getInstance()

        /*                 call functions to login with GOOGLE                */

        createRequest()

        binding.loginWithGoogle.setOnClickListener {
            signIn()
        }



        // **************************************************************** \\



        /*                 call functions to login with EMAIL                */

        logInEmail()

        // **************************************************************** \\





        // goto register activity button
        binding.registerButtonLogin.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }


        // return back arrow function
        backArrow()

    }



    /*                  FUNCTIONS to login with GOOGLE                */

    private fun createRequest() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN!!)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignIn = GoogleSignIn.getClient(this, gso)
    }


    private fun signIn() {

        val intent = mGoogleSignIn.signInIntent
        startActivityForResult(intent, 123)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 123) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)!!
                Log.d(ContentValues.TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
                Toast.makeText(applicationContext, "Connexion réussie", Toast.LENGTH_SHORT).show()

            } catch (e: ApiException) {
                Toast.makeText(this, "échouée", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    updateUI(user)

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(applicationContext, "Connexion échouée", Toast.LENGTH_SHORT)
                        .show()
                    updateUI(null)

                }
            }
    }




    /*                  FUNCTIONS to login with EMAIL                */

    // login with email and password function
    private fun logInEmail() {

        val emailCaseLogin = findViewById<EditText>(R.id.email_case_login)
        val passwordCaseLogin = findViewById<EditText>(R.id.password_case_login)

        findViewById<Button>(R.id.login_button)
            .setOnClickListener {
                val email = emailCaseLogin.text.toString()
                val password = passwordCaseLogin.text.toString()

                if (email.isEmpty()) {
                    Toast.makeText(
                        applicationContext, "Rentrez votre e-mail", Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }


                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->

                        if (task.isSuccessful) {
                            startActivity(Intent(applicationContext, MainActivity::class.java))
                            finish()
                            val user = auth.currentUser
                            updateUI(user)
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "E-mail ou mot de passe incorrect",
                                Toast.LENGTH_SHORT
                            ).show()
                            updateUI(null)
                        }
                    }
            }
    }

    // back arrow
    private fun backArrow() {
        val backArrow = findViewById<ImageView>(R.id.backArrow)
        backArrow.setOnClickListener {
            finish()
            startActivity(Intent(applicationContext, FirstActivity::class.java))

        }
    }

    private fun updateUI(user: FirebaseUser?) {

    }

    override fun onBackPressed() {
        // super.onBackPressed()
    }
}