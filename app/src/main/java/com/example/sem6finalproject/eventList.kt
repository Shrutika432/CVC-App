package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FirebaseFirestore
import java.io.Serializable

class eventList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)
        val firestore = FirebaseFirestore.getInstance()
        firestore.collection("events").get()
            .addOnSuccessListener { querySnapShot ->
                var eventListView: ListView = this.findViewById(R.id.eventListView)
                var events: Array<Event?> =
                    querySnapShot.documents.map { event ->
                        var e: Event? = event.toObject(Event::class.java)
                        e?.id = event.id
                        return@map e
                    }
                        .toTypedArray()
                var eventNames: Array<String?> = events.map { event -> event?.eventdec }.toTypedArray()

                var eventListAdapter: ArrayAdapter<String?> =
                    ArrayAdapter<String?>(this, android.R.layout.simple_list_item_1, eventNames)

                eventListView.setOnItemClickListener { parent, view, index, id ->

                    var uid = FirebaseAuth.getInstance().currentUser?.uid;
                    var profile: DocumentSnapshot;
                    FirebaseFirestore.getInstance().collection("profile").document(uid.toString())
                        .get().addOnSuccessListener { doc ->
                            profile = doc;
                            var isAdmin = profile["isAdmin"];
                            if (isAdmin != true) {
                                var intent = Intent(this, eventDetails::class.java)
                                intent.putExtra("event", events[index])
                                startActivity(intent)
                            } else {
                                var intent = Intent(this, intrested_Volunteer::class.java)
                                intent.putExtra("event", events[index])
                                startActivity(intent)
                            }
                        }
                }

                eventListView.adapter = eventListAdapter

            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
            }

    }
}

class Event : Serializable {
    var id = ""
    var eventdate = ""
    var area = ""
    var eventdec = ""
    var nov = ""
    var points = ""
    var volunteers:List<String> = listOf()

    constructor()
    constructor(
        id:String,
        eventdate: String,
        area: String,
        eventdec: String,
        nov: String,
        points: String,
        volunteers:List<String>

    ) {

        this.id = id
        this.eventdate = eventdate
        this.area = area
        this.eventdec = eventdec
        this.nov = nov
        this.points = points
        this.volunteers=volunteers
    }

}