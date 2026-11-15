
package com.hourlyproduction.report

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            showHome()
        } catch (e: Exception) {
            showError(e)
        }
    }

    private fun showError(e: Exception) {
        val message = TextView(this).apply {
            text = "App Error:\n${e.message}"
            textSize = 16f
            setPadding(24, 24, 24, 24)
        }
        setContentView(ScrollView(this).apply {
            addView(message)
        })
    }

    private fun showHome() {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(24, 24, 24, 24)
            setBackgroundColor(Color.WHITE)
        }

        val title = TextView(this).apply {
            text = "HOURLY PRODUCTION REPORT"
            textSize = 23f
            gravity = Gravity.CENTER
            setTextColor(Color.BLACK)
        }

        val admin = Button(this).apply {
            text = "ADMIN LOGIN"
            setOnClickListener { showEntry() }
        }

        val employee = Button(this).apply {
            text = "EMPLOYEE LOGIN"
            setOnClickListener { showEntry() }
        }

        layout.addView(title)
        layout.addView(admin)
        layout.addView(employee)

        setContentView(layout)
    }

    private fun showEntry() {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(20, 20, 20, 20)
        }

        val title = TextView(this).apply {
            text = "PRODUCTION ENTRY"
            textSize = 24f
        }

        val floor = Spinner(this)
        floor.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Select Floor", "Floor 1", "Floor 2", "Floor 3")
        )

        val selectedLines = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val checks = (1..30).map { number ->
            CheckBox(this).apply {
                text = "Line $number"
            }
        }

        checks.forEach { selectedLines.addView(it) }

        val scroll = ScrollView(this)
        scroll.addView(selectedLines)

        val hour = Spinner(this)
        hour.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf(
                "Select Hour", "9 AM", "10 AM", "11 AM",
                "12 PM", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM"
            )
        )

        val quantity = EditText(this).apply {
            hint = "Enter Production Quantity"
            inputType = 2
        }

        val save = Button(this).apply {
            text = "SAVE PRODUCTION"
            setOnClickListener {
                val chosen = checks.filter { it.isChecked }

                if (floor.selectedItemPosition == 0 ||
                    chosen.isEmpty() ||
                    hour.selectedItemPosition == 0 ||
                    quantity.text.toString().isBlank()
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        "Fill all information",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Demo Entry Successful",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        layout.addView(title)
        layout.addView(floor)
        layout.addView(scroll, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f
        ))
        layout.addView(hour)
        layout.addView(quantity)
        layout.addView(save)

        setContentView(layout)
    }
}
