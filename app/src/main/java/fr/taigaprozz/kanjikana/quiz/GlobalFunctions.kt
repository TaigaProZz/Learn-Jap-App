package fr.taigaprozz.kanjikana.quiz

import android.app.Application
import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import fr.taigaprozz.kanjikana.account.LoginActivity

object GlobalFunctions: Application() {
    @JvmStatic
    fun changeActivityFromImage(imageView: ImageView, clazz: Class<*>?) {
        imageView.setOnClickListener{
            val intent = Intent(applicationContext, clazz)
            startActivity(intent)

        }
    }

    fun changeActivityFromText(textView: TextView, context: Context, clazz: Class<*>?) {
        textView.setOnClickListener{
            val intent = Intent(context, clazz)
            startActivity(intent)

        }
    }
}
