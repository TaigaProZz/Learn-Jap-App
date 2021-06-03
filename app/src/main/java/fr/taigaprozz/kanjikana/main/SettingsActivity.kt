package fr.taigaprozz.kanjikana.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import fr.taigaprozz.R
import fr.taigaprozz.kanjikana.account.LoginActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    // val photo = findViewById<ImageView>(R.id.photo_view)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        auth = FirebaseAuth.getInstance()

        // call function to show user's info
        getUserProfile()

        signOut()

    }

    // show user info
    private fun getUserProfile() {
        val email = findViewById<TextView>(R.id.email_view)

        val user = auth.currentUser
        if (user != null) {
            val userEmail = user.email
            val photoUrl = user.photoUrl

            email.text = userEmail
        }
    }

    private fun getGoogleUser() {
        val user = auth.currentUser
    }

    private fun signOut() {
        val signOutButton = findViewById<Button>(R.id.signOut_button)

        signOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
            startActivity(Intent(applicationContext, LoginActivity::class.java))
        }

    }
}

