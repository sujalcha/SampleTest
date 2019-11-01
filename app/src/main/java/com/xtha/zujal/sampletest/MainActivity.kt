package com.xtha.zujal.sampletest

import android.app.Application
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.xtha.zujal.sampletest.Model.UserInfo
import android.os.AsyncTask.execute
import android.util.Log
import com.xtha.zujal.sampletest.Adapters.UserAdapter
import org.json.JSONArray
import org.json.JSONException
import android.arch.lifecycle.ViewModelProviders
import com.xtha.zujal.sampletest.Adapters.AlbumAdapter
import com.xtha.zujal.sampletest.ViewModels.MainActivityViewModel
import com.xtha.zujal.sampletest.ViewModels.ViewModelMainActivity
import android.support.v4.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T






class MainActivity : AppCompatActivity() {

    private var adapter: UserAdapter? = null
    private var usertask :UserTask? = null
    var User: ArrayList<UserInfo> = arrayListOf<UserInfo>()

    private var mViewModel: ViewModelMainActivity? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview :ListView = findViewById(R.id.getusers)

        //var s = UserTask(this).execute("getusers");


       // val model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java!!)
        val model = ViewModelProviders.of(this)[ViewModelMainActivity::class.java]
        model.getUsers().observe(this, Observer<java.util.ArrayList<UserInfo>>{ users ->
            // update UI
            adapter = UserAdapter(this, users)
            listview.setAdapter(adapter)
        })



      //  model.prepareData();

//        mViewModel= ViewModelMainActivity(this.application);
//        var koko : String = mViewModel.toString()
//
//        Log.i("KOKO",koko)
//
//        mViewModel!!.prepareData();

//        val usertask = UserTask( this)
//
//        usertask.execute("getusers")


       // model.prepareData()

       // Log.i("User",""+model.getuser())
       // adapter = UserAdapter(this, model.asyncTask())

//        val User : ArrayList<UserInfo>  = model.getUsers()
//        Log.i("User",""+User)
//        listview.setAdapter(adapter)
    }


}
