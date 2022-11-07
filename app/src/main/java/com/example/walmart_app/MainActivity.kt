package com.example.walmart_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.walmart_app.Helpers.Validators
import com.example.walmart_app.Models.User
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var users = ArrayList(arrayListOf(
        User("Felipe", "Zeba", "felipe@gmail.com", "felipe123"),
        User("John", "Smith", "john@gmail.com", "john123"),
        User("Randolf", "George", "ransolf@gmail.com", "randolf123"),
        User("Liza", "Johnson", "liza@gmail.com", "liza123"),
        User("Emilly", "Blunt", "emilly@gmail.com", "amilly123"),
    ))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_signin.setOnClickListener {
            var email = input_email.text.toString()
            var password = input_password.text.toString()
            if(email != "" && password != "") {
                if(Validators.isValidEmail(email)) {
                    var returneduser = findUserByEmail(email)
                    if (returneduser != null) {
                        if(returneduser.password == password) {
                            input_email.text.clear()
                            input_password.text.clear()
                            var intent = Intent(this, HomeActivity::class.java)
                            intent.putExtra("username", returneduser.firstname)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Invalid password", Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "E-mail is invalid", Toast.LENGTH_LONG).show()
                }
            }else {
                Toast.makeText(this, "Both e-mail and password are required", Toast.LENGTH_LONG).show()
            }
        }

        btn_forgot_password.setOnClickListener{
            var email = input_email.text.toString()
            if(email != "") {
                var user = findUserByEmail(email)
                if(user != null) {
                    // send user.password to user.email
                    // implicit Intent Intent.Action_Send
                }
            } else {
                Toast.makeText(this, "Enter your e-mail to retrive the password", Toast.LENGTH_LONG).show()
            }
        }

        var resultContracts = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK) {
                var user = it.data?.getSerializableExtra("user") as? User
                if(checkUserExists(user!!)) {
                    Toast.makeText(this, "E-mail already exists", Toast.LENGTH_LONG).show()
                } else {
                    users.add(user);
                    Toast.makeText(this, "Account created, please login", Toast.LENGTH_LONG).show()
                }
            } else {
                Log.i("signup", "Error getting account data")
            }
        }

        btn_create_account.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
            resultContracts.launch(intent)
        }
    }

    fun findUserByEmail(email: String): User? {
        var user: User? = null
        users.forEach{
            if(it.email == email) {
                user = it
            }
        }
        return user
    }

    fun checkUserExists(user: User): Boolean {
        var userExists = false
        users.forEach{
            if(it.email == user.email) {
                userExists =  true
            }
        }
        return userExists
    }
}