package com.example.employeedetails

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddEmployeeActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var designationEditText: EditText
    private lateinit var salaryEditText: EditText
    private lateinit var addEmployeeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText)
        designationEditText = findViewById(R.id.designationEditText)
        salaryEditText = findViewById(R.id.salaryEditText)
        addEmployeeButton = findViewById(R.id.addEmployeeButton)

        // Set click listener for Add Employee button
        addEmployeeButton.setOnClickListener {
            addEmployee()
        }
    }

    private fun addEmployee() {
        // Get input values from EditTexts
        val name = nameEditText.text.toString().trim()
        val designation = designationEditText.text.toString().trim()
        val salaryStr = salaryEditText.text.toString().trim()

        // Validate input values
        if (name.isEmpty() || designation.isEmpty() || salaryStr.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Convert salary to Double
        val salary = try {
            salaryStr.toDouble()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Invalid salary format", Toast.LENGTH_SHORT).show()
            return
        }

        // Create Employee object with input values
        val employee = Employee(id = 1, name = name, designation = designation, salary = salary)

        // Add employee to data source (e.g., database)
        // Here you would implement your logic to add the employee to the database

        // Show success message
        Toast.makeText(this, "Employee added successfully", Toast.LENGTH_SHORT).show()

        // Optionally, you can finish() the activity or navigate back to the previous screen
        // finish()
    }
}
