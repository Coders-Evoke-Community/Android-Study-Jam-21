package com.example.fruitfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemsList: ArrayList<Item>
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView = findViewById(R.id.recycler_view)
        itemsList = ArrayList()

        //get the data from received intent
        val type = getIntent().getStringExtra("type")

        val db = FirebaseFirestore.getInstance()
        db.collection("Items")
            .whereEqualTo("type", type)   //Query
            .get()  //Read
            .addOnSuccessListener {

                for (doc in it.documents) {
                    //The result is in JSON format
                    // so we need to convert it into our required class objects
                    val item = doc.toObject(Item::class.java)
                    itemsList.add(item!!)
                }

                itemAdapter = ItemAdapter(itemsList)
                recyclerView.adapter = itemAdapter

            }.addOnFailureListener {
                it.printStackTrace()
            }
    }

}