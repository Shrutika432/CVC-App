package com.example.sem6finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_signin2.*
import org.w3c.dom.Text

class profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        showdata()
    }
    fun showdata()
    {
        var auth=FirebaseAuth.getInstance()
        var firestore=FirebaseFirestore.getInstance()
        var name=findViewById<TextView>(R.id.tvname)
        var position=findViewById<TextView>(R.id.tvposition)
        var pcontact=findViewById<TextView>(R.id.tvcontact)
        var pemail=findViewById<TextView>(R.id.tvemail)
        var paddress=findViewById<TextView>(R.id.tvaddress)
        var points=findViewById<TextView>(R.id.score)


        var uid=auth.currentUser?.uid
        if(uid!=null)
        {
            firestore.collection("profile").document(uid.toString()).get()
                .addOnSuccessListener{document->
                    name.setText(document.data?.get("fullname").toString())
                    position.setText(document.data?.get("position").toString())
                    pcontact.setText(document.data?.get("cnum").toString())
                    pemail.setText(document.data?.get("email").toString())
                    paddress.setText(document.data?.get("address").toString())
                    points.setText(document.data?.get("Points").toString())


                    Toast.makeText(this,uid.toString(),Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this,"not found",Toast.LENGTH_LONG).show()

                }
        }
    }
}
