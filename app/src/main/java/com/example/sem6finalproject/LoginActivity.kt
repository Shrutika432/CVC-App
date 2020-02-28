
package com.example.sem6finalproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login.*
import com.afollestad.vvalidator.form


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        textDonate.setOnClickListener {
            val intent:Intent=Intent(this,Donationform::class.java)
            startActivity(intent)

        }

        Handler().postDelayed({
           BtnLogIn.setOnClickListener{

               //Toast.makeText(this,"test",Toast.LENGTH_LONG).show()
                var email:String=findViewById<EditText>(R.id.etUsername).text.toString()
                var password:String=findViewById<EditText>(R.id.etPassword).text.toString()

                var errormsg:String=""

                if(!isEmailValid(email)){
                errormsg="email is not valid"
            }
            else if(password.length<6){
                errormsg="password is not valid"
            }

                findViewById<TextView>(R.id.tvLoginError).setText(errormsg)
                if(errormsg.isEmpty()){
                    login(email,password)
                }


            }

        },500)
//        val intent=Intent(this,LoginConformationActivity::class.java)
//        startActivity(intent)


        LinkSignUp.setOnClickListener{
            val intent=Intent(this,SignupActivity1::class.java)
            startActivity(intent)
        }
    }
    fun isEmailValid(email: String): Boolean {
        val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})";
        return EMAIL_REGEX.toRegex().matches(email);
    }

    fun login(email: String,password:String){
        var auth=FirebaseAuth.getInstance()
        var firestore = FirebaseFirestore.getInstance()
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
           task ->
            if(task.isSuccessful) {
                var uid = auth.currentUser?.uid;
                var profile:DocumentSnapshot;
                firestore.collection("profile").document(uid.toString()).get().addOnSuccessListener {
                    doc -> profile = doc;
                    var isAdmin = profile["isAdmin"];
                    if(isAdmin != true){
                        val intent=Intent(this,VolunteerDashboard::class.java)
                        startActivity(intent)
                    }else{
                        val intent=Intent(this,AdminDashboard::class.java)
                        startActivity(intent)
                        //Toast.makeText(this,"Admin Page",Toast.LENGTH_LONG).show()
                    }
                   var preference=getSharedPreferences("loginpref",Context.MODE_PRIVATE)
                    var editor=preference.edit()

                    editor.putString("uname",R.id.etUsername.toString())
                    editor.commit()


                }
            }
            else
     {
              Toast.makeText(this,"Fail",Toast.LENGTH_LONG).show()
            }
        }

    }

}
