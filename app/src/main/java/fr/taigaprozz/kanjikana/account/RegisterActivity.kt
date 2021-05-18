package fr.taigaprozz.kanjikana.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import fr.taigaprozz.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerEmail = findViewById<EditText>(R.id.emailRegister)
        val registerPassword = findViewById<EditText>(R.id.passwordRegister)
        val registerPasswordConfirm = findViewById<EditText>(R.id.passwordRegisterConfirm)
        val buttonRegister = findViewById<Button>(R.id.registerButton)

        // collect register data from user when register button is pressed
        buttonRegister.setOnClickListener {
            var email = registerEmail.text.toString()
            var password = registerPassword.text.toString()
            var passwordConfirm = registerPasswordConfirm.text.toString()

        // inspect if user complete correctly
            if (email.isEmpty()){
                registerEmail.error = "Un e-mail valide est requis"
            }
            if (!email.contains("@")){
                registerEmail.error = "Un e-mail valide est requis"
            }
            if (!email.contains(".")){
                registerEmail.error = "Un e-mail valide est requis"
            }



        }
    }
}