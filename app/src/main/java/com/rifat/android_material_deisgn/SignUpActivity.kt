package com.rifat.android_material_deisgn

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {

    lateinit var fullName:TextView
    lateinit var userName:TextView
    lateinit var userEmail:TextView
    lateinit var signUpButton:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        fullName=findViewById(R.id.signUpFullName)
        userName=findViewById(R.id.signUpUserName)
        userEmail=findViewById(R.id.signUpEmail)
        signUpButton=findViewById(R.id.btnSignUp)


    }

    //Validation Form
    fun validateName():Boolean{
        var name=fullName.text.toString();
        if(name.isNullOrEmpty()){
            fullName.error="Field can not be empty"
            return false
        }else{
            return true
        }
    }

    fun registerUser(view:View){
        var userFullName=fullName.text.toString();
        var userName=userName.text.toString();
        var userEmail=userEmail.text.toString();
    }
}