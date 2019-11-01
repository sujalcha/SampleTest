package com.xtha.zujal.sampletest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView

class Album : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        val sessionId = intent.getIntExtra("userid",0)

        Log.d("User ID", ""+sessionId)

        val  listview : ListView = findViewById(R.id.albumlist)
        val  albumid : TextView = findViewById(R.id.albumid)

        AlbumTask(sessionId,listview,albumid,this).execute("getalbums")


    }
}
