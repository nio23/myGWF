package com.example.mygwf


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class LoginActivity : AppCompatActivity() {

lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val usernameET =findViewById<EditText>(R.id.username)
        val passwordET =findViewById<EditText>(R.id.password)
        val apiClient = ApiClient()
        val sessionManager = SessionManager(this)

        viewModel = ViewModelProvider(this, ViewModelFactory(Repository(apiClient = apiClient, session= sessionManager))).get(LoginViewModel::class.java)



        viewModel.loginResponse.observe(this, Observer { loginResponse->
            Log.d("TOKEN",loginResponse.access)
            Toast.makeText(this,"Logged in",Toast.LENGTH_SHORT).show()
            //sessionManager.saveAuthToken(loginResponse.access)
            viewModel.saveToken(loginResponse.access)
            startActivity(Intent(this, MetersActivity::class.java))

        })

        viewModel.issueResponse.observe(this, Observer { issue->
            Toast.makeText(this, issue.toString(), Toast.LENGTH_SHORT).show()
        })

        loginBtn.setOnClickListener{
            viewModel.login(username=usernameET.text.toString().trim(), password= passwordET.text.toString().trim())

        }
    }



}


