package com.xtha.zujal.sampletest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ImageDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_details)

        val imagetitle = intent.getStringExtra("imagetitle")
        val imageurl = intent.getStringExtra("imageurl")
        val imagealbumid = intent.getStringExtra("imagealbumid")
        val imagephotoid = intent.getStringExtra("imagephotoid")

        val imagetext : TextView = findViewById(R.id.imagetext)
        val image : ImageView = findViewById(R.id.imageView)
        val albumid : TextView = findViewById(R.id.imagealbumid)
        val photoid : TextView = findViewById(R.id.imagephotoid)

        ImageTask(image,this).execute(imageurl)
        albumid.setText(imagealbumid)
        photoid.setText(imagephotoid)
        imagetext.setText(imagetitle)


    }
}
