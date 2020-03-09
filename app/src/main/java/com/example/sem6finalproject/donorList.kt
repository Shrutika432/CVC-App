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

class DonorList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_list)

        FirebaseFirestore.getInstance().collection("donordetails").get()
            .addOnSuccessListener { querySnapShot ->

                var donorListView: ListView = this.findViewById(R.id.donorListView)

                var donors: Array<Donor?> =
                    querySnapShot.documents.map { donor -> donor.toObject(Donor::class.java) }
                        .toTypedArray()
                var donorNames: Array<String?> = donors.map { donor -> donor?.Dname }.toTypedArray()

                var donorListAdapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, donorNames)

                donorListView.setOnItemClickListener { parent, view, index, id ->
                    var intent = Intent(this, donorReport::class.java)
                    intent.putExtra("donor", donors[index])
                    startActivity(intent)
                }


                donorListView.adapter = donorListAdapter

            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
            }

    }
}

class Donor : Serializable {
    var Dname = ""

    var Demail = ""
    var Dcontact = ""
    var Daddress = ""
    var DPanNo = ""
    var DPayOption = ""
    var Dpurpose = ""

    constructor()
    constructor(
        Dname: String,
        Demail: String,
        Dcontact: String,
        Daddress: String,
        DPanNo: String,
        DPayOption: String,
        Dpurpose: String
    ) {

        this.Dname = Dname
        this.Demail = Demail
        this.Dcontact = Dcontact
        this.Daddress = Daddress
        this.DPanNo = DPanNo
        this.DPayOption = DPayOption
        this.Dpurpose = Dpurpose
    }

    override fun toString(): String {
        return super.toString()
    }

}
