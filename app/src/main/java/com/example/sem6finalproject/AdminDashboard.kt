package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_admin_dashboard.*

class AdminDashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        BtnCreateEvent.setOnClickListener{
            //Toast.makeText(this,txtCreateEvent.text.toSToast.LENGTH_LONG).show()
            var intent= Intent(this,Crtevt::class.java)
            startActivity(intent)
        }
        BtnAdminDonate.setOnClickListener {
            var intent:Intent= Intent(this,Donationform::class.java)
            startActivity(intent)
        }
        BtnGenerateReports.setOnClickListener {
            var intent=Intent(this,reports_dashboard::class.java)
            startActivity(intent)
        }

    }
}
