package com.jaycodes.signuppage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.jaycodes.signuppage.R
import com.jaycodes.signuppage.Countries

class CountryAdapter(private val countriesList : List<Countries>, private val context : Context) : BaseAdapter() {
    override fun getCount(): Int {
        return countriesList.size
    }

    override fun getItem(position: Int): Any {
        return countriesList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        val viewHolder : ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.customspinner, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.countryName?.text = countriesList[position].name
        viewHolder.about?.text = countriesList[position].description

        return view
    }

    private class ViewHolder(view: View?) {
        val countryName : TextView? = view?.findViewById(R.id.spiname)
        val about : TextView? = view?.findViewById(R.id.spiabout)
    }
}