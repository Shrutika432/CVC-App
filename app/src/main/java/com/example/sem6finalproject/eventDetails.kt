package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_donor_report.*
import kotlinx.android.synthetic.main.activity_event_details.*
import kotlinx.android.synthetic.main.activity_reports_dashboard.*
import kotlinx.android.synthetic.main.change_password.view.*
import java.io.Serializable

class eventDetails : AppCompatActivity() {
    //var id="54kqrLhEYlQh4ck2b7Ou"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)
        var event: Event? = intent.getSerializableExtra("event") as? Event
        readEvent(event)
        var user = FirebaseAuth.getInstance().currentUser

        eventDetailsYesBtn.setOnClickListener {
            val eventDB: DocumentReference =
                FirebaseFirestore.getInstance().collection("createEvent").document(event!!.id)

            eventDB.update("volunteers", FieldValue.arrayUnion(user!!.uid)).addOnSuccessListener {
                    Toast.makeText(this,  "Thank you for being in this event!", Toast.LENGTH_LONG).show()
                }.addOnFailureListener{e->
                Toast.makeText(this,  e.toString(), Toast.LENGTH_LONG).show()

            }

        }


        joinevent.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.joinconfirmation, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Confirmation")
            //show dialog
            val  mAlertDialog = mBuilder.show()
            //login button click of custom layout
            mDialogView.dialogDoneBtn.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()

            }
            //cancel button click of custom layout
            mDialogView.dialogCancelBtn.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
            }
        }
    }

    fun readEvent(event: Event?) {
        var firestore = FirebaseFirestore.getInstance()
        var eventdec = findViewById<TextView>(R.id.eventdec)
        var eventdate = findViewById<TextView>(R.id.eventdate)
        var area = findViewById<TextView>(R.id.eventarea)
        var nov = findViewById<TextView>(R.id.eventnov)
        var points = findViewById<TextView>(R.id.eventpoints)


        eventdec.setText(event?.eventdec.toString())
        eventdate.setText(event?.eventdate.toString())
        area.setText(event?.area.toString())
        nov.setText(event?.nov.toString())
        points.setText(event?.points.toString())


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

