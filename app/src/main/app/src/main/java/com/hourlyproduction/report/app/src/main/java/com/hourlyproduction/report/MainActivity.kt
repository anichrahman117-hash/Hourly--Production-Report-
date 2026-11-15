package com.hourlyproduction.report

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun createLayout() {
        layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(30, 30, 30, 30)
            setBackgroundColor(Color.rgb(245, 247, 250))
        }
    }

    private fun showHome() {
        createLayout()

        val title = TextView(this).apply {
            text = "HOURLY PRODUCTION REPORT"
            textSize = 24f
            gravity = Gravity.CENTER
            setTextColor(Color.BLUE)
        }

        val admin = Button(this).apply {
            text = "ADMIN LOGIN"
            setOnClickListener { showLogin("ADMIN") }
        }

        val employee = Button(this).apply {
            text = "EMPLOYEE LOGIN"
            setOnClickListener { showLogin("EMPLOYEE") }
        }

        layout.addView(title)
        layout.addView(admin)
        layout.addView(employee)

        setContentView(layout)
    }

    private fun showLogin(role: String) {
        createLayout()

        val title = TextView(this).apply {
            text = "$role LOGIN"
            textSize = 25f
            gravity = Gravity.CENTER
            setTextColor(Color.BLUE)
        }

        val username = EditText(this).apply {
            hint = "Enter User ID"
        }

        val password = EditText(this).apply {
            hint = "Enter Password"
            inputType = 129
        }

        val login = Button(this).apply {
            text = "LOGIN"
            setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "Login system will be connected next",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val back = Button(this).apply {
            text = "BACK"
            setOnClickListener { showHome() }
        }

        layout.addView(title)
        layout.addView(username)
        layout.addView(password)
        layout.addView(login)
        layout.addView(back)

        setContentView(layout)
    }
}
