package com.example.youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //3 imp things required : View, Data, Adapter

    // 1. View : the layout which will be reused
    private lateinit var videosRecyclerView: RecyclerView
    // 2. Data : the information which is to be shown
    private lateinit var videosList: ArrayList<YTVideo>
    // 3. Adapter : the class which will take the layout, fill the data in it & show it on screen
    private lateinit var videosAdapter: VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //View
        videosRecyclerView = findViewById(R.id.videos_recycler_view)

        //Data
        videosList = ArrayList()
        populateList()

        //Adapter
        videosAdapter = VideoAdapter(this, videosList)

        //Attaching Adapter to View
        videosRecyclerView.adapter = videosAdapter
    }

    /* this is just for example. We have hardcoded the values here but
     this data may also come from database / network source */
    private fun populateList() {
        YTVideo().apply {
            thumbnailId = R.drawable.tn1
            title = "Peace at Mountains"
            channel = "Wanderer Tanya"
            viewsCount = 50000
            date = "2 days ago"
            videosList.add(this)
        }
        YTVideo().apply {
            thumbnailId = R.drawable.tn2
            title = "We went for a City Bus ride"
            channel = "Girl on Wheels"
            viewsCount = 15000
            date = "4 days ago"
            videosList.add(this)
        }
        YTVideo().apply {
            thumbnailId = R.drawable.tn3
            title = "My First Video"
            channel = "Aesthetic Vibes"
            viewsCount = 65000
            date = "a week ago"
            videosList.add(this)
        }
        YTVideo().apply {
            thumbnailId = R.drawable.tn4
            title = "You won't believe animals live here"
            channel = "National Geo"
            viewsCount = 5000
            date = "6 days ago"
            videosList.add(this)
        }
        YTVideo().apply {
            thumbnailId = R.drawable.tn5
            title = "Our Youtube Car"
            channel = "Love Fam"
            viewsCount = 10000
            date = "2 months ago"
            videosList.add(this)
        }
        YTVideo().apply {
            thumbnailId = R.drawable.tn6
            title = "Views Views & Views"
            channel = "Traveller Insan"
            viewsCount = 99000
            date = "3 days ago"
            videosList.add(this)
        }
        YTVideo().apply {
            thumbnailId = R.drawable.tn7
            title = "Amazing Photoshoot Locations"
            channel = "Apna Guru"
            viewsCount = 80000
            date = "12 minutes ago"
            videosList.add(this)
        }
        YTVideo().apply {
            thumbnailId = R.drawable.tn8
            title = "Is the hike worth it?"
            channel = "Flying Boomer"
            viewsCount = 20000
            date = "a day ago"
            videosList.add(this)
        }
    }

}