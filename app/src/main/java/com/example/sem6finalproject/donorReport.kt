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

class donorReport : AppCompatActivity() {
//var id="54kqrLhEYlQh4ck2b7Ou"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_report)
        var donor:Donor? = intent.getSerializableExtra("donor") as? Donor
        readDonor(donor)

    }

    fun readDonor(donor:Donor?)
    {
        var firestore=FirebaseFirestore.getInstance()
        var Dname=findViewById<TextView>(R.id.tvDonationForm)
        var Dcontact=findViewById<TextView>(R.id.textDcontact)
        var Daddress=findViewById<TextView>(R.id.textDaddress)
        var Dpanno=findViewById<TextView>(R.id.textDPANno)
        var Dpayoption=findViewById<TextView>(R.id.textpayment)
        var Demail=findViewById<TextView>(R.id.textDemail)
        var Dpurpose=findViewById<TextView>(R.id.textDpurpose)

                Dname.setText(donor?.Dname.toString())
                Dcontact.setText(donor?.Dcontact.toString())
                Demail.setText(donor?.Demail.toString())
                Dpurpose.setText(donor?.Dpurpose.toString())
                Daddress.setText(donor?.Daddress.toString())
                Dpanno.setText(donor?.DPanNo.toString())
                Dpayoption.setText(donor?.DPayOption.toString())

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

