package com.example.employeedetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EmployeeDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)

        // Retrieve employee details from intent extras
        val employee: Employee? = intent.getParcelableExtra("employee")

        if (employee != null) {
            // Display employee details
            findViewById<TextView>(R.id.nameTextView).text = "Name: ${employee.name}"
            findViewById<TextView>(R.id.designationTextView).text = "Designation: ${employee.designation}"
            findViewById<TextView>(R.id.salaryTextView).text = "Salary: ${employee.salary}"
        }
    }
}
