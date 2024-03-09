package com.example.employeedetails

import android.app.Application

class MyApplication : Application() {

    private val employeeList: MutableList<Employee> = mutableListOf()

    fun getEmployeeList(): MutableList<Employee> {
        return employeeList
    }

    fun addEmployee(employee: Employee) {
        employeeList.add(employee)
    }
}
