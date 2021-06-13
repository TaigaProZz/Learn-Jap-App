package fr.taigaprozz.kanjikana.account

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import fr.taigaprozz.databinding.ActivityFirstBinding.inflate
import fr.taigaprozz.kanjikana.GlobalFunctions
import fr.taigaprozz.kanjikana.main.MainActivity

class FirstActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onStart() {
        super.onStart()

        // check if the user is already connected
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        // goto main activity if user is already connected
        if (user != null) {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // no animation when activity is changed
        GlobalFunctions.setNoAnimation(this)
        // view binding
        val binding = inflate(layoutInflater)
        val view = binding.root


        Handler(Looper.getMainLooper()).postDelayed({
            setContentView(view)
        }, 500)


        binding.loginButtonFromFirstActivity.setOnClickListener {
            startActivity(Intent(applicationContext, LoginActivity::class.java))
        }
        binding.registerButtonFromFirstActivity.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }

    }

}