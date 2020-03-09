package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_donor_list.*
import kotlinx.android.synthetic.main.activity_reports_dashboard.*

class reports_dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports_dashboard)
        Btndonorreport.setOnClickListener {
            var intent=Intent(this,DonorList::class.java)
            startActivity(intent)
        }
        BtnVolunteerReport.setOnClickListener {
            var intent=Intent(this,volunteerList::class.java)
            startActivity(intent)
        }
        BtnEventReport.setOnClickListener {
            var intent=Intent(this,eventList::class.java)
            startActivity(intent)
        }
    }
}
