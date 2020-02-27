package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signin3.*

class SignupActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin3)

        BtnBack2.setOnClickListener{
            val intent= Intent(this,SignupActivity2::class.java)
            startActivity(intent)
        }

        BtnSubmit.setOnClickListener {
            val intent:Intent= Intent(this,VolunteerDashboard::class.java)
            startActivity(intent)
        }


    }
}
