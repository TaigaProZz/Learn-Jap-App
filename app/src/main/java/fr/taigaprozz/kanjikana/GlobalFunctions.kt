package fr.taigaprozz.kanjikana

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.RemoteException
import androidx.appcompat.app.AppCompatActivity
import java.security.AccessControlContext

object GlobalFunctions: AppCompatActivity() {

    // no animation when activity is changed
    fun setNoAnimation(activity: Activity){
        activity.overridePendingTransition(0, 0)

    }



//fun changeActivityFromImage(imageView: ImageView, clazz: Class<*>?) {
//    imageView.setOnClickListener{
//        val intent = Intent(applicationContext, clazz)
//        startActivity(intent)

//    }
//}

//fun changeActivityFromText(textView: TextView, context: Context, clazz: Class<*>?) {
//    textView.setOnClickListener{
//        val intent = Intent(context, clazz)
//        startActivity(intent)

//    }
//}


}
