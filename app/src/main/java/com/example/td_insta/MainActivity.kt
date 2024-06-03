package com.example.td_insta

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private fun isInputValid(email: EditText, password : EditText): Boolean {
        val email_text = email.text.toString()
        val password_text = password.text.toString()
        return !email_text.trim().isEmpty() and !password_text.trim().isEmpty()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val email = findViewById<EditText>(R.id.email_input)
        val password = findViewById<EditText>(R.id.password_input)
        val button = findViewById<Button>(R.id.login_button)
        val errorMsg = findViewById<TextView>(R.id.error)

        val correctAccount = "user"
        val correctPassword = "123456"
        button.setOnClickListener {
            errorMsg.visibility = View.GONE

            val userAccount = email.text.toString()
            val userPassword = password.text.toString()

            if(userAccount.trim().isEmpty() || userPassword.trim().isEmpty()) {
                Toast.makeText(this, "Les champs doivent être renseignés", Toast.LENGTH_LONG).show()
            } else {
                if(userAccount == correctAccount && userPassword == correctPassword) {
                    val intentToHomeActivity : Intent = Intent(this, HomeActivity::class.java)
                    intentToHomeActivity.putExtra("user_account", userAccount)
                    startActivity(intentToHomeActivity)
                } else {
                    errorMsg.visibility = View.VISIBLE
                    errorMsg.text = "Les informations sont incorrectes"
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}