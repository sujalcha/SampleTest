package com.xtha.zujal.sampletest.ViewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.xtha.zujal.sampletest.Adapters.UserAdapter
import com.xtha.zujal.sampletest.Model.UserInfo
import com.xtha.zujal.sampletest.UserTask
import org.json.JSONArray
import org.json.JSONException

class MainActivityViewModel(application: Application) : AndroidViewModel(application),UserTask.AsyncResponse  {

    override fun processFinish(output: String) {
        Log.d("output", output)
    }

    var User: ArrayList<UserInfo> = arrayListOf<UserInfo>()
    var Haude: ArrayList<UserInfo>? = null

    var stin: String = ""
    //   UserTask(listview, this).execute("getusers")

/*

    fun getuseers() {
        UserTask(object : UserTask.AsyncResponse {
            override fun processFinish(output: String) {
                //Here you will receive the result fired from async class
                //of onPostExecute(result) method.
                stin = output
                User = ArrayList<UserInfo>()

                try {
                    val jArray = JSONArray(output)

                    for (i in 0 until jArray.length()) {

                        val jObject = jArray.getJSONObject(i)

                        val id = jObject.getInt("id")
                        val name = jObject.getString("name")
                        val email = jObject.getString("email")
                        val phonenumber = jObject.getString("phone")

                        val userInfo = UserInfo(id, name, email, phonenumber)
                        User.add(userInfo)

                        Haude = User
                    } // End Loop

                } catch (e: JSONException) {
                    Log.e("JSONException", "Error: $e")
                }
                // catch (JSONException e)
            }
        }, getApplication<Application>().applicationContext).execute(
            "getusers"
        )

    }

*/

}

