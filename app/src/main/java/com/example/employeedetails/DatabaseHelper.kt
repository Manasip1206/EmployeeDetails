package com.example.employeedetails

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val SQL_CREATE_EMPLOYEE_TABLE = """
            CREATE TABLE ${EmployeeContract.EmployeeEntry.TABLE_NAME} (
                ${EmployeeContract.EmployeeEntry.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${EmployeeContract.EmployeeEntry.COLUMN_NAME} TEXT NOT NULL,
                ${EmployeeContract.EmployeeEntry.COLUMN_DESIGNATION} TEXT NOT NULL,
                ${EmployeeContract.EmployeeEntry.COLUMN_SALARY} REAL NOT NULL
            );
        """.trimIndent()

        db.execSQL(SQL_CREATE_EMPLOYEE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL("DROP TABLE IF EXISTS ${EmployeeContract.EmployeeEntry.TABLE_NAME}")
        onCreate(db)
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Employee.db"
    }
}
