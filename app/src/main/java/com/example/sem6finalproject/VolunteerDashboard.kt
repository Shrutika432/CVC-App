package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin_dashboard.*
import kotlinx.android.synthetic.main.activity_volunteer_dashboard.*

class VolunteerDashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer_dashboard)

        BtnDonate.setOnClickListener {
            startActivity(Intent(this,Donationform::class.java))
        }
        Fab_Action_RemoveAc.setOnClickListener {
            var intent:Intent= Intent(this,removeAccount::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.logout,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.logoutitem){
            Toast.makeText(this,"logout successfully",Toast.LENGTH_LONG).show()
        }

        return super.onOptionsItemSelected(item)
    }

}
