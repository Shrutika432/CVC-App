package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LoginConformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_conformation)

        Handler().postDelayed({
            val intent= Intent(this,volunteerDashboard::class.java)
            startActivity(intent)
            finish()
        },500)


    }
}
