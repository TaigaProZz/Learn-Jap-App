package fr.taigaprozz.kanjikana.account

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.taigaprozz.databinding.ActivityFirstBinding.inflate

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.loginButtonFromFirstActivity.setOnClickListener {
            startActivity(Intent(applicationContext, LoginActivity::class.java))}
        binding.registerButtonFromFirstActivity.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java)) }

    }
}