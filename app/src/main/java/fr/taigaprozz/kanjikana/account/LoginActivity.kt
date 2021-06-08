package fr.taigaprozz.kanjikana.account

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import fr.taigaprozz.R
import fr.taigaprozz.databinding.ActivityLoginBinding.inflate
import fr.taigaprozz.kanjikana.main.MainActivity
import fr.taigaprozz.kanjikana.account.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var mGoogleSignIn: GoogleSignInClient
    private var RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = FirebaseAuth.getInstance()

        /*                 call functions to login with GOOGLE                */

        createRequest()
        signIn()

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
        startActivityForResult(intent, RC_SIGN_IN)

    }

    // TODO:   CONNECT BUTTON FOR GOOGLE


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
}