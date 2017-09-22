package com.example.roshan.navigation

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import android.widget.TextView

import android.content.Context.LAYOUT_INFLATER_SERVICE
import com.example.roshan.kotlinjsonparsing.Model_class
import com.example.roshan.kotlinjsonparsing.R


/**
 * Created by roshan on 9/21/17.
 */

class AdapterClass : ArrayAdapter<Model_class> {

    var classList: ArrayList<Model_class>
    private val resource: Int
    private val inflater: LayoutInflater

    //constructor(context: Context, resource: Int) : super(context, resource) {}
    constructor(context: Context, resource: Int, classList: ArrayList<Model_class>) : super(context, resource, classList) {

        this.classList = classList
        this.resource = resource
        inflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            holder = ViewHolder()
            convertView = inflater.inflate(R.layout.adapter, null)

            holder.tvIname = convertView.findViewById(R.id.tv_name) as TextView
            holder.tvDesc = convertView.findViewById(R.id.tv_des) as TextView

            convertView.tag = holder

        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.tvIname!!.text = classList[position].str_name
        holder.tvDesc!!.text = classList[position].str_des
        println("Data "+classList[position].str_des)

        return convertView
    }

    internal inner class ViewHolder {
       // var imageView: ImageView? = null
        var tvIname: TextView? = null
        var tvDesc: TextView? = null
    }
}
