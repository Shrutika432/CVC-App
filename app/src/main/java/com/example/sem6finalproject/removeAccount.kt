package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_remove_account.*

class removeAccount : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove_account)

        BtnDelete.setOnClickListener {
            //Toast.makeText(this,"Your account deleted successfully!!",Toast.LENGTH_LONG).show()
            deletevolunteer()



        }
        BtnDcancel.setOnClickListener {
            var intent=Intent(this,VolunteerDashboard::class.java)
            startActivity(intent)
        }
    }
    fun deletevolunteer()
    {
        var auth= FirebaseAuth.getInstance()
        var firestore= FirebaseFirestore.getInstance()

        var uid=auth.currentUser?.uid
        if(uid!=null) {
            firestore.collection("profile").document(uid.toString())
                .delete().addOnSuccessListener {
                    Toast.makeText(this, "account deleted successfully", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "error deleting account", Toast.LENGTH_LONG).show()
                }
        }
        else{
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
