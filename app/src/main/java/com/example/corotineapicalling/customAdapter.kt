package com.example.corotineapicalling

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class customAdapter(val context: Context,val dataList:List<Item>):BaseAdapter() {
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = LayoutInflater.from(context).inflate(R.layout.layout, parent, false)

        val data = dataList[position]
        val name = rowView.findViewById<TextView>(R.id.name)
        val email = rowView.findViewById<TextView>(R.id.email)
        name.setText(data.name)
        email.setText(data.email)
        return rowView
    }
}