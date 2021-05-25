package fr.taigaprozz.kanjikana.account

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import fr.taigaprozz.R

import fr.taigaprozz.kanjikana.quiz.GlobalFunctions


class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val returnArrow = findViewById<ImageView>(R.id.return_button)


     //returnArrow.setOnClickListener{
     //    val intent=Intent(applicationContext, LoginActivity::class.java)
     //    startActivity(intent)
     //}

        val auth = FirebaseAuth.getInstance()
        val registerEmail = findViewById<EditText>(R.id.emailRegister)
        val registerPassword = findViewById<EditText>(R.id.passwordRegister)
        val registerPasswordConfirm = findViewById<EditText>(R.id.passwordRegisterConfirm)
        val buttonRegister = findViewById<Button>(R.id.registerButton)
        val googleRegisterButton = findViewById<Button>(R.id.googleRegisterButton)

        // collect register data from user when register button is pressed

        buttonRegister.setOnClickListener {
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
                registerEmail.error = "Un e-mail valide est requis"
                validationCheck = false
            }
            // email field contains " @ " and " . "
            else if (!email.contains("@")) {
                registerEmail.error = "Un e-mail valide est requis"
                validationCheck = false
            }

            else if (!email.contains(".")) {
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
            }
            else if (!upperBool) {
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



        // google auth

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN!!)
            .requestEmail()
            .build()

        val mGoogle = GoogleSignIn.getClient(this, gso)

        googleRegisterButton.setOnClickListener{
           val intent= mGoogle.signInIntent
            startActivityForResult(intent, 1)

        }

        GlobalFunctions.changeActivityFromImage(returnArrow, LoginActivity::class.java)

    }


    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)
    }

    private fun updateUI(user: GoogleSignInAccount?) {

    }

}
