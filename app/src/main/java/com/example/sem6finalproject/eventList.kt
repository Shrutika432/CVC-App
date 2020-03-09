package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import java.io.Serializable

class eventList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)

        FirebaseFirestore.getInstance().collection("createEvent").get()
            .addOnSuccessListener { querySnapShot ->

                var eventListView: ListView = this.findViewById(R.id.eventListView)

                var events: Array<Event?> =
                    querySnapShot.documents.map { event -> event.toObject(Event::class.java) }
                        .toTypedArray()
                var eventNames: Array<String?> = events.map { event -> event?.eventdec }.toTypedArray()

                var eventListAdapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventNames)

                eventListView.setOnItemClickListener { parent, view, index, id ->
                    var intent = Intent(this,eventDetails::class.java)
                    intent.putExtra("event", events[index])
                    startActivity(intent)
                }


                eventListView.adapter = eventListAdapter

            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
            }

    }
}

class Event : Serializable {
    var eventdate = ""
    var area = ""
    var eventdec = ""
    var nov = ""
    var points = ""


    constructor()
    constructor(
        eventdate: String,
        area: String,
        eventdec: String,
        nov: String,
        points: String

    ) {

        this.eventdate = eventdate
        this.area = area
        this.eventdec = eventdec
        this.nov = nov
        this.points = points
    }

    override fun toString(): String {
        return super.toString()
    }

}
