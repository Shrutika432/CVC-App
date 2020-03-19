package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_signin3.*

class SignupConformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin3)

        val fade= AnimationUtils.loadAnimation(this,R.anim.fade)
        val cvc= AnimationUtils.loadAnimation(this,R.anim.cvc)

        val ImageLoginCmf=findViewById(R.id.ImageLoginCmf) as ImageView
        val TextLoginSucc=findViewById(R.id.TextLoginSucc) as TextView

        ImageLoginCmf.startAnimation(fade)
        TextLoginSucc.startAnimation(cvc)


        Handler().postDelayed({
            val intent= Intent(this,VolunteerDashboard::class.java)
            startActivity(intent)
            finish()
        },3000)



    }
}
