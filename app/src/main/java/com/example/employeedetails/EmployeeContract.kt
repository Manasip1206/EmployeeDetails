package com.example.employeedetails

import android.provider.BaseColumns

object EmployeeContract {

    // Inner class that defines the table contents
    class EmployeeEntry : BaseColumns {
        companion object {
            const val TABLE_NAME = "employee"
            const val COLUMN_NAME = "name"
            const val COLUMN_DESIGNATION = "designation"
            const val COLUMN_SALARY = "salary"
            const val ID = BaseColumns._ID
                // Other column constants
            }

        }
    }
