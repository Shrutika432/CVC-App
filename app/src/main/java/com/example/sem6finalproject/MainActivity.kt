package com.example.sem6finalproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging

const val TAG="Hii"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user:String? = FirebaseAuth.getInstance().currentUser?.uid;
        Log.d("USER", user.toString())

        if (user != null) {
            FirebaseFirestore.getInstance().collection("profile").document(user).get().addOnSuccessListener {
                    doc -> var profile = doc;
                var isAdmin = profile["isAdmin"];
                if(isAdmin != true){

                    Handler().postDelayed({
                        val intent=Intent(this,VolunteerDashboard::class.java)
                        startActivity(intent)
                    }, 1000)

                }else{
                    Handler().postDelayed({
                        val intent=Intent(this,AdminDashboard::class.java)
                        startActivity(intent)
                    }, 1000)

                }
            }
        } else {
            Handler().postDelayed({
                val intent=Intent(this,LoginActivity::class.java)
                startActivity(intent)
            },1000)
        }



        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                // Log and toast
                val msg = "Tokan"
                Log.d(TAG, msg)
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            })
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
    }
}
