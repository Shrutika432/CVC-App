package com.example.sem6finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_change_password.*
import kotlinx.android.synthetic.main.changepass_dialog.*
import kotlinx.android.synthetic.main.changepass_dialog.view.*

class Change_Password : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        mainLoginBtn.setOnClickListener {
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.changepass_dialog, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Login Form")
            //show dialog
            val  mAlertDialog = mBuilder.show()
            //login button click of custom layout
            mDialogView.dialogLoginBtn.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
                //get text from EditTexts of custom layout
                val name = mDialogView.dialogNameEt.text.toString()
                val email = mDialogView.dialogEmailEt.text.toString()
                val password = mDialogView.dialogPasswEt.text.toString()
                //set the input text in TextView
                mainInfoTv.setText("Name:"+ name +"\nEmail: "+ email +"\nPassword: "+ password)
            }
            //cancel button click of custom layout
            mDialogView.dialogCancelBtn.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
            }
        }
    }
}

