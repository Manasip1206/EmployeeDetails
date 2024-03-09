package com.example.employeedetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class EmployeeListAdapter(private val context: Context, private val employeeList: List<Employee>) :
    BaseAdapter() {

    override fun getCount(): Int = employeeList.size

    override fun getItem(position: Int): Any = employeeList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.employee_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val employee = employeeList[position]
        viewHolder.nameTextView.text = employee.name
        viewHolder.designationTextView.text = employee.designation
        viewHolder.salaryTextView.text = employee.salary.toString()

        return view
    }

    private class ViewHolder(view: View) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val designationTextView: TextView = view.findViewById(R.id.designationTextView)
        val salaryTextView: TextView = view.findViewById(R.id.salaryTextView)
    }
}
