package fr.taigaprozz.kanjikana.account

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import fr.taigaprozz.R
import fr.taigaprozz.databinding.ActivityRegisterBinding.inflate


class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var mGoogle: GoogleSignInClient
    private var RC_SIGN_IN = 123

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()


        // call request function to google and firebase
        createRequest()

        // google sign in button
        binding.googleRegisterButton.setOnClickListener {
            signIn()
        }



        // arrow to go back function
        backArrow()

        // collect register data from user when register button is pressed
            val auth = FirebaseAuth.getInstance()
            val registerEmail = findViewById<EditText>(R.id.emailRegister)
            val registerPassword = findViewById<EditText>(R.id.passwordRegister)
            val registerPasswordConfirm = findViewById<EditText>(R.id.passwordRegisterConfirm)

            val registerButton = findViewById<Button>(R.id.registerButton).setOnClickListener {
                var validationCheck = true
                val email = registerEmail.text.toString()
                val password = registerPassword.text.toString()
                val passwordConfirm = registerPasswordConfirm.text.toString()

                var upperBool = false
                for (c in password) {
                    if (c.isUpperCase()) {
                        upperBool = true
                    }
                }

                // inspection of user data for registering

                // email field is empty
                if (email.isEmpty()) {
                    registerEmail.error = "Un e-mail est requis"
                    validationCheck = false
                }

                // email field contains " @ " and " . "
                else if (!email.contains("@")) {

                    registerEmail.error = "Un e-mail valide est requis"
                    validationCheck = false
                } else if (!email.contains(".")) {
                    registerEmail.error = "Un e-mail valide est requis"
                    validationCheck = false
                }

                // password field is empty
                else if (passwordConfirm.isEmpty()) {
                    registerPassword.error = "Choisissez votre mot de passe"
                    validationCheck = false
                }

                // password is a minimum strong
                else if (passwordConfirm.length < 7) {
                    registerPassword.error = "Le mot de passe est trop petit"
                    validationCheck = false
                } else if (!upperBool) {
                    registerPassword.error = "Il faut une majuscule minimum"
                    validationCheck = false
                }

                // password and password confirmation are equals
                else if (passwordConfirm != password) {
                    registerPasswordConfirm.error = "Le mot de passe ne correspond pas"
                    validationCheck = false
                }

                if (validationCheck) {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                        val intent = Intent(applicationContext, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }

    //
    private fun createRequest() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN!!)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
          mGoogle = GoogleSignIn.getClient(this, gso)
    }

    private fun signIn() {
            val intent = mGoogle.signInIntent
            startActivityForResult(intent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int ,resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode== RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            }
            catch (e: ApiException){
                Toast.makeText(this, "Impossible de se connecter", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                }
            }
    }



    private fun updateUI(user: FirebaseUser?) {
    }




    // back arrow
    private fun backArrow() {
        val binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.backArrow.setOnClickListener {
            finish()
            startActivity(Intent(applicationContext, FirstActivity::class.java))
        }
    }

}
