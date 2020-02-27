package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.afollestad.vvalidator.util.hide
import com.afollestad.vvalidator.util.show
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_signin2.*

class SignupActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin2)
        val textOther = findViewById<EditText>(R.id.TextOther)
        textOther.hide()

        BtnNext2.setOnClickListener{
            submitForm2()
//            val intent=Intent(this,SignupActivity3::class.java)
//            startActivity(intent)
        }

        BtnBack1.setOnClickListener{
//            val intent=Intent(this,SignupActivity1::class.java)
//            startActivity(intent)
        }

        val otherRadio = findViewById<RadioButton>(R.id.Radio7)
        otherRadio.setOnClickListener {
            textOther.show()
        }
    }
    fun submitForm2()
    {
        var auth= FirebaseAuth.getInstance()
        var firestore= FirebaseFirestore.getInstance()

        var hobbies:String=findViewById<EditText>(R.id.textHobbies).text.toString()
        var pastevent:String=findViewById<EditText>(R.id.textPastEvent).text.toString()
        var oevent:String=findViewById<EditText>(R.id.textOEvent).text.toString()
        var shareanything:String=findViewById<EditText>(R.id.textShareAnything).text.toString()


        val profile2= mapOf(
            "hobbies" to hobbies,
            "pastevent" to pastevent,
            "oevent" to oevent,
            "shareanything" to shareanything

            )


            var uid=auth.currentUser?.uid
            firestore.collection("profile").document(uid.toString()).update(profile2).addOnSuccessListener { doc->
                val intent=Intent(this,SignupActivity3::class.java)
                startActivity(intent)
            }




    }
} 
