package com.example.roshan.kotlinjsonparsing

import android.util.Log

import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import org.json.JSONArray

import org.json.JSONException
import org.json.JSONObject

import java.io.IOException

/**
 * Created by roshan on 9/22/17.
 */

object JSONParser {
    /********
     * URLS
     */
     val MAIN_URL = "http://10.42.0.1/Zappfood/Menu/Appetizer.php"
    /**
     * TAGs Defined Here...
     */
    val TAG = "TAG"


    private var response: Response? = null
    /**
     * Get Table Booking Charge

     * @return JSON Object
     */
    val dataFromWeb: JSONArray?
        get() {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                        .url(MAIN_URL)
                        .build()
                response = client.newCall(request).execute()
                return JSONArray(response!!.body().string())
            } catch (e: IOException) {
                Log.e(TAG, "" + e.localizedMessage)
            } catch (e: JSONException) {
                Log.e(TAG, "" + e.localizedMessage)
            }

            return null
        }
}