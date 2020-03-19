package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class intrested_Volunteer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intrested__volunteer)
        var event: Event = intent.getSerializableExtra("event") as Event

        var volunteerList: ListView = findViewById(R.id.intVolunteerListView)

        var volunteerNames: Array<String?> = event.volunteers.toTypedArray()

        var volunteerListAdapter: ArrayAdapter<String?> =
            ArrayAdapter<String?>(this, android.R.layout.simple_list_item_1, volunteerNames)

        volunteerList.setOnItemClickListener { parent, view, index, id ->
        }

        readEvent(event)
        volunteerList.adapter = volunteerListAdapter
    }
    fun readEvent(event: Event?) {
        var firestore = FirebaseFirestore.getInstance()
        var eventdec = findViewById<TextView>(R.id.tveventdec)
        var eventdate = findViewById<TextView>(R.id.tveventdate)
        var area = findViewById<TextView>(R.id.tvVol)
        var nov = findViewById<TextView>(R.id.tvcity)
        var points = findViewById<TextView>(R.id.tvpoints)

        eventdec.setText(event?.eventdec.toString())
        eventdate.setText(event?.eventdate.toString())
        area.setText(event?.area.toString())
        nov.setText(event?.nov.toString())
        points.setText(event?.points.toString())

    }
}