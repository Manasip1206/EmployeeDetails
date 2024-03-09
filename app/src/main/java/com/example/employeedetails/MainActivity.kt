package com.example.employeedetails

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var employeeListView: ListView
    private lateinit var addEmployeeButton: Button
    private lateinit var adapter: EmployeeListAdapter

    private var employeeList: MutableList<Employee> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        employeeListView = findViewById(R.id.employeeListView)
        adapter = EmployeeListAdapter(this, getEmployeeList())
        addEmployeeButton = findViewById(R.id.addEmployeeButton)

        // Initialize adapter
        employeeListView.adapter = adapter

        // Add employee button click listener
        addEmployeeButton.setOnClickListener {
            val intent = Intent(this, AddEmployeeActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        // Refresh employee list when returning to this activity
        adapter.notifyDataSetChanged()
    }
    private fun getEmployeeList(): List<Employee> {
        // Fetch employee data from database
        // Replace this with your database query logic
        val employeeList = mutableListOf<Employee>()
        employeeList.add(Employee(1, "John Doe", "Manager", 50000.0))
        employeeList.add(Employee(2, "Jane Smith", "Engineer", 60000.0))
        // Add more employees as needed

        return employeeList
    }


}