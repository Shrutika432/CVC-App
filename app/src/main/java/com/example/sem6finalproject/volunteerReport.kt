package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_donor_report.*
import kotlinx.android.synthetic.main.activity_reports_dashboard.*
import java.io.Serializable

class volunteerReport: AppCompatActivity() {
    //var id="54kqrLhEYlQh4ck2b7Ou"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_report)
        var volunteer:Volunteer? = intent.getSerializableExtra("volunteer") as? Volunteer
        readvolunteer(volunteer)

    }

    fun readvolunteer(volunteer:Volunteer?)
    {
        var firestore=FirebaseFirestore.getInstance()
        var fullname=findViewById<TextView>(R.id.tvVname)
        var cnum=findViewById<TextView>(R.id.textVolcontact)
        var email=findViewById<TextView>(R.id.textVolemail)
        var position=findViewById<TextView>(R.id.textVolposition)
        var address=findViewById<TextView>(R.id.textVoladdress)
        var dob=findViewById<TextView>(R.id.textVolDOB)
        var gender=findViewById<TextView>(R.id.textVolgender)
        var bgroup=findViewById<TextView>(R.id.textVOlBloodgroup)



        fullname.setText(volunteer?.fullname.toString())
        cnum.setText(volunteer?.cnum.toString())
        email.setText(volunteer?.email.toString())
        position.setText(volunteer?.position.toString())
        address.setText(volunteer?.address.toString())
        dob.setText(volunteer?.dob.toString())
        gender.setText(volunteer?.gender.toString())
        bgroup.setText(volunteer?.bgroup.toString())

//        firestore.collection("donordetails").document(id.toString()).get()
//            .addOnSuccessListener {document ->
//
//                var data:Donor?=document.toObject(Donor::class.java)
//                Dname.setText(data?.Dname.toString())
//                Dcontact.setText(data?.Dcontact.toString())
//                Demail.setText(data?.Demail.toString())
//                Dpurpose.setText(data?.Dpurpose.toString())
//                Daddress.setText(data?.Daddress.toString())
//                Dpanno.setText(data?.DPanNo.toString())
//                Dpayoption.setText(data?.DPayOption.toString())
//
//            }
//            .addOnFailureListener {
//                Toast.makeText(this,"data not found",Toast.LENGTH_LONG).show()
//
//            }
    }

}

