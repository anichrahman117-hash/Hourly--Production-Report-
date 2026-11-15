package com.hourlyproduction.report

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun showHome() {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(24, 24, 24, 24)
        layout.gravity = Gravity.CENTER
        layout.setBackgroundColor(Color.WHITE)

        val title = TextView(this)
        title.text = "HOURLY PRODUCTION REPORT"
        title.textSize = 23f
        title.gravity = Gravity.CENTER

        val admin = Button(this)
        admin.text = "ADMIN LOGIN"
        admin.setOnClickListener { showEntry() }

        val employee = Button(this)
        employee.text = "EMPLOYEE LOGIN"
        employee.setOnClickListener { showEntry() }

        layout.addView(title)
        layout.addView(admin)
        layout.addView(employee)

        setContentView(layout)
    }

    private fun showEntry() {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(20, 20, 20, 20)

        val title = TextView(this)
        title.text = "PRODUCTION ENTRY"
        title.textSize = 24f

        val floor = Spinner(this)
        floor.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Select Floor", "Floor 1", "Floor 2", "Floor 3")
        )

        val lines = Array(30) { "Line ${it + 1}" }
        val selectedLines = LinearLayout(this)
        selectedLines.orientation = LinearLayout.VERTICAL

        val checks = lines.map { line ->
            CheckBox(this).apply {
                text = line
            }
        }

        checks.forEach { selectedLines.addView(it) }

        val scroll = ScrollView(this)
        scroll.addView(selectedLines)

        val hour = Spinner(this)
        hour.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Select Hour", "9 AM", "10 AM", "11 AM", "12 PM",
                "1 PM", "2 PM", "3 PM", "4 PM", "5 PM")
        )

        val quantity = EditText(this)
        quantity.hint = "Enter Production Quantity"
        quantity.inputType = 2

        val save = Button(this)
        save.text = "SAVE PRODUCTION"
        save.setOnClickListener {
            val chosen = checks.filter { it.isChecked }
            if (floor.selectedItemPosition == 0 ||
                chosen.isEmpty() || quantity.text.isEmpty()) {
                Toast.makeText(this, "Fill all information", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Entry demo completed", Toast.LENGTH_SHORT).show()
            }
        }

        layout.addView(title)
        layout.addView(floor)
        layout.addView(scroll)
        layout.addView(hour)
        layout.addView(quantity)
        layout.addView(save)

        setContentView(layout)
    }
}
