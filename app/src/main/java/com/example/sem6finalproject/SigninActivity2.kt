package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signin2.*

class SigninActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin2)

        BtnNext2.setOnClickListener{
            val intent=Intent(this,SigninActivity3::class.java)
            startActivity(intent)
        }

        BtnBack1.setOnClickListener{
            val intent=Intent(this,SigninActivity1::class.java)
            startActivity(intent)
        }
    }
} 
