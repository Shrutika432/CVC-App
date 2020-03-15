package com.example.sem6finalproject

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_create_event.*
import java.util.*

class Crtevt : AppCompatActivity() {

    lateinit var option : Spinner
    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        option = findViewById<Spinner>(R.id.SpinnerAreaOption)
        result = findViewById<TextView>(R.id.SpinnerArearesult)

        val options = arrayOf("Waghodiya","Gorva","Manjalpur","Gotri")
        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)


        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text="Please select an option"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                result.text = options.get(position)
            }

        }
        BtnPost.setOnClickListener {
            createvent()
        }

    }
    fun addDate(view:View)
    {
        var dpd: DatePickerDialog;
        val C= Calendar.getInstance()
        val year=C.get(Calendar.YEAR)
        var month=C.get(Calendar.MONTH)
        var day=C.get(Calendar.DAY_OF_MONTH)
        val date=findViewById<EditText>(R.id.textEventDate)

        dpd= DatePickerDialog(this,R.style.DialogTheme,
            DatePickerDialog.OnDateSetListener{
                    view,year,month,day-> date.setText("$day / ${month+1} / $year")
            },year,month,day)
        dpd.show()

    }
    fun createvent()
    {
        var firestore=FirebaseFirestore.getInstance()
        var eventdate:String=findViewById<EditText>(R.id.textEventDate).text.toString()
        var eventdec:String=findViewById<EditText>(R.id.textDOB).text.toString()
        var nov:String=findViewById<EditText>(R.id.TextNov).text.toString()
        var area:String=findViewById<TextView>(R.id.SpinnerArearesult).text.toString()
        var points:String=findViewById<EditText>(R.id.TextPoint).text.toString()
        val vols: Array<String> = arrayOf()
        val createEvent = hashMapOf(
            "eventdate" to eventdate,
            "eventdec" to eventdec,
            "nov" to nov,
            "area" to area,
            "points" to points,
            "volunteers" to Arrays.asList(*vols)
        )
        firestore.collection("events").add(createEvent).addOnSuccessListener { doc->
            Toast.makeText(this,"event posted Successfully.",Toast.LENGTH_LONG).show()
        }
            .addOnFailureListener {
                Toast.makeText(this,"event failed to post",Toast.LENGTH_LONG).show()
            }
    }
}
