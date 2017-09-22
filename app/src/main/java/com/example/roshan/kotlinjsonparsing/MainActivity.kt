package com.example.roshan.kotlinjsonparsing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.example.roshan.kotlinjsonparsing.Model_class
import com.example.roshan.navigation.AdapterClass
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    val model_class=ArrayList<Model_class>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list =findViewById(R.id.lv_flower) as ListView


        Thread(Runnable {

            try {

                val jsonArray = JSONParser.dataFromWeb!!
                println("Array"+jsonArray)
                val lenArray = jsonArray.length()
                println("length :"+lenArray)

                for (jIndex in 0..lenArray - 1) {
                    val c = jsonArray.getJSONObject(jIndex)
                    val menu= c.optString("Menu_Type")
                    val item=c.optString("Item_Name")
                    model_class.add(Model_class(menu,item))
                    println("Row :"+menu)
                }
            } catch (je: JSONException) {
                Log.i(JSONParser.TAG, "" + je.localizedMessage)
            }

        }).start()

        val adapter : AdapterClass
        adapter = AdapterClass(applicationContext,R.layout.adapter,model_class)
        list.adapter=adapter
    }
}
