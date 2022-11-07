package com.example.walmart_app

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.walmart_app.Helpers.Validators
import com.example.walmart_app.Models.User
import kotlinx.android.synthetic.main.activity_main.btn_create_account
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        btn_create_account.setOnClickListener {
            var fname = input_first_name.text.toString()
            var lname = input_last_name.text.toString()
            var email = input_email_signup.text.toString()
            var password = input_password_signup.text.toString()

            if(fname != "" && lname != "" && email != "" && password != "") {
                if(Validators.isValidEmail(email)) {
                    val user = User(fname, lname, email, password)
                    var intent = intent
                    intent.putExtra("user", user)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                } else {
                    Toast.makeText(this, "E-mail is invalid", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT)
            }
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}