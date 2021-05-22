package fr.taigaprozz.kanjikana.account

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import fr.taigaprozz.R
import fr.taigaprozz.kanjikana.main.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val loginEmail = findViewById<EditText>(R.id.email_case_login)
        val loginPassword = findViewById<EditText>(R.id.password_case_login)

        val loginButton = findViewById<Button>(R.id.login_button)
        val gotoRegisterButton = findViewById<Button>(R.id.registerButtonLogin)

        loginButton.setOnClickListener{
            val email = loginEmail.text.toString()
            val password = loginPassword.text.toString()

            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){ task ->


                if(task.isSuccessful){
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    val user = auth.currentUser
                    updateUI(user)
                }
                else{
                    Toast.makeText(baseContext, "E-mail ou mot de passe incorrect",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }

        }


        gotoRegisterButton.setOnClickListener {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun updateUI(user: FirebaseUser?) {

    }
}