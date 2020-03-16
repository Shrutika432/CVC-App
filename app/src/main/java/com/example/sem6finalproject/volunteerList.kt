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

class volunteerList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer_list)

        FirebaseFirestore.getInstance().collection("profile").get()
            .addOnSuccessListener { querySnapShot ->

                var volunteerList: ListView = findViewById(R.id.volunteerListView)

                var volunteers: Array<Volunteer?> =
                    querySnapShot.documents.map { volunteer -> volunteer.toObject(Volunteer::class.java) }
                        .toTypedArray()

                var volunteerNames: Array<String?> = volunteers.map { volunteer -> volunteer?.fullname }.toTypedArray()

                var volunteerListAdapter: ArrayAdapter<String?> =
                    ArrayAdapter<String?>(this, android.R.layout.simple_list_item_1, volunteerNames)

                volunteerList.setOnItemClickListener { parent, view, index, id ->
                    var intent = Intent(this,volunteerReport::class.java)
                    intent.putExtra("volunteer", volunteers[index])
                    startActivity(intent)
                }


                volunteerList.adapter = volunteerListAdapter

            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
            }

    }
}

    class Volunteer : Serializable {
        var fullname = ""
        var cnum = ""
        var email = ""
        var position = ""
        var address = ""
        var dob = ""
        var gender = ""
        var bgroup = ""
        var points = 0

    constructor()
    constructor(
        fullname: String,
        cnum: String,
        position: String,
        address: String,
        dob: String,
        gender: String,
        bgroup: String,
        points: Int
    ) {
        this.fullname = fullname
        this.cnum = cnum
        this.position = position
        this.address = address
        this.dob = dob
        this.gender = gender
        this.bgroup = bgroup
        this.points = points
    }

    override fun toString(): String {
        return super.toString()
    }

}
