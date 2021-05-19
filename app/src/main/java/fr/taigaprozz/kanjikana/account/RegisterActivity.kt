package fr.taigaprozz.kanjikana.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import fr.taigaprozz.R

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val auth = FirebaseAuth.getInstance()
        val registerEmail = findViewById<EditText>(R.id.emailRegister)
        val registerPassword = findViewById<EditText>(R.id.passwordRegister)
        val registerPasswordConfirm = findViewById<EditText>(R.id.passwordRegisterConfirm)
        val buttonRegister = findViewById<Button>(R.id.registerButton)


        // collect register data from user when register button is pressed

        buttonRegister.setOnClickListener {
            val email = registerEmail.text.toString()
            val password = registerPassword.text.toString()
            val passwordConfirm = registerPasswordConfirm.text.toString()

            // inspection of user data for registering

            // email field is empty
            if (email.isEmpty()) {
                registerEmail.error = "Un e-mail valide est requis"
            }
            // email field contains " @ " and " . "
            else if (!email.contains("@")) {
                registerEmail.error = "Un e-mail valide est requis"
            } else if (!email.contains(".")) {
                registerEmail.error = "Un e-mail valide est requis"
            }
            // password field is empty
            else if (passwordConfirm.isEmpty()) {
                registerPassword.error = "Choisissez votre mot de passe"
            }
            // password and password confirmation are equals
            else if (passwordConfirm != password) {
                registerPasswordConfirm.error = "Le mot de passe ne correspond pas"
            }
            // password is a minimum strong
            else if (passwordConfirm.length < 7) {
                registerPassword.error = "Le mot de passe est trop petit"
            }

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
                .addOnFailureListener(this){

                }

        }
    }
}
