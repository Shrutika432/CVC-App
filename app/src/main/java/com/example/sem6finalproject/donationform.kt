package com.example.sem6finalproject

import android.content.Intent
import android.net.http.SslCertificate
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_donationform.*

class Donationform : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donationform)
        btnDonation.setOnClickListener {
            submitDonationForm()
            //Toast.makeText(this,"Thank You for your Donation!!",Toast.LENGTH_LONG).show()
        }
    }
    fun submitDonationForm()
    {
        var firestore=FirebaseFirestore.getInstance()

        var Dname:String=findViewById<EditText>(R.id.textDname).text.toString()
        var Dcontact:String=findViewById<EditText>(R.id.textDcontect).text.toString()
        var Demail:String=findViewById<EditText>(R.id.textDemail).text.toString()
        var Dpurpose:String=findViewById<EditText>(R.id.textDpurpose).text.toString()
        var Daddress:String=findViewById<EditText>(R.id.textDaddress).text.toString()
        var DPanNo:String=findViewById<EditText>(R.id.textDPANno).text.toString()
        var DPayOption:String=findViewById<EditText>(R.id.textDpurpose).text.toString()

        val donorDetails= hashMapOf(
            "Dname" to Dname,
            "Dcontact" to Dcontact,
            "Demail" to Demail,
            "Dpurpose" to Dpurpose,
            "Daddress" to Daddress,
            "DPanNo" to DPanNo,
            "DPayOption" to DPayOption
        )
        firestore.collection("donordetails").add(donorDetails).addOnSuccessListener {
            Toast.makeText(this,"Donor data added successfully!!",Toast.LENGTH_LONG).show()
        }
    }


}
