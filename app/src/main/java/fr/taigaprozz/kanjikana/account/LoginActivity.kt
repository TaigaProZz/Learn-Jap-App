package fr.taigaprozz.kanjikana.account

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import fr.taigaprozz.databinding.ActivityLoginBinding.inflate
import fr.taigaprozz.kanjikana.main.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()


        binding.loginButton.setOnClickListener{
            val email = binding.emailCaseLogin.text.toString()
            val password = binding.passwordCaseLogin.text.toString()


            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){ task ->

                if(task.isSuccessful){
                    startActivity(Intent(applicationContext, MainActivity::class.java))
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

        binding.registerButtonLogin.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))

        }

        // back arrow
        binding.backArrow.setOnClickListener {
            finish()
            startActivity(Intent(applicationContext, FirstActivity::class.java))
        }

    }
    private fun updateUI(user: FirebaseUser?) {

    }
}