package com.example.sem6finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.afollestad.vvalidator.util.hide
import com.afollestad.vvalidator.util.show
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_signin2.*

class SignupActivity2 : AppCompatActivity() {

    lateinit var position : Spinner
    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin2)

        position = findViewById<Spinner>(R.id.SpinnerAreaOption)
        result = findViewById<TextView>(R.id.SpinnerArearesult)

        val positions = arrayOf("Volunteer","Camp head","Sub Camp Head","Recourse Manager")
        position.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,positions)


        position.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text="Please select position"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                pos: Int,
                id: Long
            ) {
                result.text = positions.get(pos)
            }

        }


        val textOther = findViewById<EditText>(R.id.TextOther)
        textOther.hide()

        BtnNext2.setOnClickListener{
            submitForm2()
        }

        BtnBack1.setOnClickListener{
            val intent=Intent(this,SignupActivity1::class.java)
            startActivity(intent)
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
        var position:String=findViewById<TextView>(R.id.SpinnerArearesult).text.toString()
        var pastevent:String=findViewById<EditText>(R.id.textPastEvent).text.toString()
        var oevent:String=findViewById<EditText>(R.id.textOEvent).text.toString()

        val profile2= mapOf(
            "hobbies" to hobbies,
            "position" to position,
            "pastevent" to pastevent,
            "oevent" to oevent)

        Log.d("SUBMIT FORM", "Clicked")
            var uid=auth.currentUser?.uid
            firestore.collection("profile").document(uid.toString()).update(profile2).addOnSuccessListener { doc->
                val intent=Intent(this,SignupConformationActivity::class.java)
                startActivity(intent)
            }
                .addOnFailureListener {

                    Toast.makeText(this,"failed",Toast.LENGTH_LONG).show()

                }




    }
} 
