package fr.taigaprozz.kanjikana.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import fr.taigaprozz.R
import fr.taigaprozz.kanjikana.GlobalFunctions.setNoAnimation
import fr.taigaprozz.kanjikana.account.LoginActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    // val photo = findViewById<ImageView>(R.id.photo_view)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // no animation when activity is changed
        setNoAnimation(this)
        setContentView(R.layout.settings_activity)


        auth = FirebaseAuth.getInstance()

        // call function to show user's info
        getUserProfileInfo()
        getGoogleUserProfileInfo()

        // function to sign out
        signOut()

        // function for arrow to go back
        backArrow()

    }

    // show user info
    private fun getUserProfileInfo() {
        val email = findViewById<TextView>(R.id.email_view)

        val user = auth.currentUser
        if (user != null) {
            val userEmail = user.email

            email.text = userEmail
        }
    }

    private fun getGoogleUserProfileInfo() {
        val user = auth.currentUser
        val email = findViewById<TextView>(R.id.email_view)
        val name = findViewById<TextView>(R.id.name_view)
        val avatar = findViewById<ImageView>(R.id.userAvatar)

        user?.let {
            for (profile in it.providerData){

                // show name from google
                val userName = it.displayName
                if(userName == null){
                    // doNothing
                } else {
                    name.text = userName
                }

                // show email from google
                val userEmail = it.email
                email.text = userEmail

                // show image profile from google
                val userAvatar = it.photoUrl
                avatar.setImageURI(userAvatar)
                println(userAvatar)





            }
        }


    }



    private fun signOut() {
        val signOutButton = findViewById<Button>(R.id.signOut_button)

        signOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }

    }


    private fun backArrow(){
        val backArrow = findViewById<ImageView>(R.id.backArrow)
        backArrow.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

    }

}

