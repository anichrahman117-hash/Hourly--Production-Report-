package com.hourlyproduction.report

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(30, 30, 30, 30)
            setBackgroundColor(Color.rgb(245, 247, 250))
        }

        val title = TextView(this).apply {
            text = "HOURLY PRODUCTION REPORT"
            textSize = 25f
            setTextColor(Color.rgb(20, 55, 100))
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 40)
        }

        val admin = Button(this).apply {
            text = "ADMIN LOGIN"
        }

        val employee = Button(this).apply {
            text = "EMPLOYEE LOGIN"
        }

        layout.addView(title)
        layout.addView(admin)
        layout.addView(employee)

        setContentView(layout)
    }
}
