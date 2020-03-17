package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class intrested_Volunteer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intrested__volunteer)
        var event: Event = intent.getSerializableExtra("event") as Event

        var volunteerList: ListView = findViewById(R.id.intVolunteerListView)
        var volunteers:Array<Volunteer?> =  event.volunteersObj.toTypedArray()
//        var volunteers: Array<Volunteer?> = arrayOf(event.volunteers)
//        var volunteersID: Array<String> = event?.volunteers!!.toTypedArray()

//        volunteersID.forEach { v ->
//            FirebaseFirestore.getInstance().collection("profile").document(v).get().addOnSuccessListener { doc->
//                volunteers.plus(doc.toObject(Volunteer::class.java))
//            }
//        }
        var volunteerNames: Array<String?> = volunteers?.map { volunteer -> volunteer?.fullname }.toTypedArray()

        var volunteerListAdapter: ArrayAdapter<String?> =
            ArrayAdapter<String?>(this, android.R.layout.simple_list_item_1, volunteerNames)

        volunteerList.setOnItemClickListener { parent, view, index, id ->
        }


        volunteerList.adapter = volunteerListAdapter
    }
}
