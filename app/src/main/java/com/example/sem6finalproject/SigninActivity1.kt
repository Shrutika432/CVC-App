package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signin1.*

class SigninActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin1)

        BtnNext1.setOnClickListener{
            val intent=Intent(this,SigninActivity2::class.java)
            startActivity(intent)
        }
    }
}
