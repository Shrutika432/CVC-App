package com.example.sem6finalproject

import android.content.Intent
import android.app.DatePickerDialog
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.afollestad.vvalidator.form
import kotlinx.android.synthetic.main.activity_signin1.*
import java.util.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class SignupActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin1)

        BtnNext1.setOnClickListener{
            submitForm1()

        }
    }
    fun addDOB(view:View)
    {
        var dpd:DatePickerDialog;
        val C=Calendar.getInstance()
        val year=C.get(Calendar.YEAR)
        var month=C.get(Calendar.MONTH)
        var day=C.get(Calendar.DAY_OF_MONTH)
     val date=findViewById<EditText>(R.id.textDOB)

        dpd= DatePickerDialog(this,R.style.DialogTheme,
            DatePickerDialog.OnDateSetListener{
                    view,year,month,day-> date.setText("$day / ${month+1} / $year")
            },year,month,day)
        dpd.show()

    }

    fun submitForm1()
    {
        var auth=FirebaseAuth.getInstance()
        var firestore=FirebaseFirestore.getInstance()

        var email:String=findViewById<EditText>(R.id.textEmail).text.toString()
        var password:String=findViewById<EditText>(R.id.textPassword).text.toString()
        var cpassword:String=findViewById<EditText>(R.id.textConfirmPassword).text.toString()
        var fullname:String=findViewById<EditText>(R.id.textFullName).text.toString()
        var address:String=findViewById<EditText>(R.id.textResidentialAddress).text.toString()
        var dob:String=findViewById<EditText>(R.id.textDOB).text.toString()
        var cnum:String=findViewById<EditText>(R.id.TextContactNumber).text.toString()
        var occ:String=findViewById<EditText>(R.id.TextOccupation).text.toString()
        var school:String=findViewById<EditText>(R.id.TextSchool).text.toString()
        var bgroup:String=findViewById<EditText>(R.id.TextBloodGroup).text.toString()
        var genderGroup = findViewById<RadioGroup>(R.id.GroupRadio)
        var gender: String =
            findViewById<RadioButton>(genderGroup.checkedRadioButtonId).text.toString()
        

        val formValidation = form {
            input(R.id.textEmail){
                isNotEmpty()
                isEmail()
            }
            input(R.id.textPassword){
                length().greaterThan(6)
            }
            input(R.id.textConfirmPassword){
                matches(password).description("Both password must be same.")

            input(R.id.textFullName){
                isNotEmpty()
            }

            input(R.id.textDOB){
                isNotEmpty()
            }

            input(R.id.TextContactNumber){
                isNotEmpty()
                length().greaterThan(9)
            }

            }
        }
        if(!formValidation.validate().success()){
            val error = formValidation.validate().errors()[0]
          Toast.makeText(this,error.toString(),Toast.LENGTH_LONG).show()
            return
        }

        val profile= hashMapOf(
        "email" to email,
        "fullname" to fullname,
        "address" to address,
        "dob" to dob,
        "cnum" to cnum,
        "occ" to occ,
        "school" to school,
        "bgroup" to bgroup,
        "gender" to gender
        )

        auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener { doc->
                var uid=auth.currentUser?.uid
                firestore.collection("profile").document(uid.toString()).set(profile).addOnSuccessListener { doc->
                    val intent=Intent(this,SignupActivity2::class.java)
                    startActivity(intent)
                }
            Toast.makeText(this,"signup success",Toast.LENGTH_LONG).show()


        }.addOnFailureListener{
                Toast.makeText(this,"failed",Toast.LENGTH_LONG).show()

            }


    }
}
