package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_admin_dashboard.*
import kotlinx.android.synthetic.main.activity_volunteer_dashboard.*

class VolunteerDashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer_dashboard)

        BtnDonate.setOnClickListener {
            startActivity(Intent(this, Donationform::class.java))
        }
        Fab_Action_RemoveAc.setOnClickListener {
            var intent: Intent = Intent(this, removeAccount::class.java)
            startActivity(intent)
            finish()
        }
        BtnProfile.setOnClickListener {
            var intent = Intent(this, profile::class.java)
            startActivity(intent)
        }
        Fab_Action_ChangePass.setOnClickListener {
            var intent: Intent = Intent(this, Change_Password::class.java)
            startActivity(intent)

        }
        Fab_Action_Logout.setOnClickListener {
            Toast.makeText(this,"you SignOut",Toast.LENGTH_LONG).show()

//            var auth=FirebaseAuth.getInstance()
            FirebaseAuth.getInstance().signOut()
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        Fab_Action_RemoveAc.setOnClickListener {
            Toast.makeText(this,"you SignOut",Toast.LENGTH_LONG).show()

//            var auth=FirebaseAuth.getInstance()

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}
