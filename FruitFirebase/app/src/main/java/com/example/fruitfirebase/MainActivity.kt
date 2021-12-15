package com.example.fruitfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.firebase.firestore.FirebaseFirestore

/* READ THIS

Firebase is a serverless Backend as a Service
Firestore is the document style no-SQL database under firebase

To run this project, you need to complete these steps :
1. create a project at https://console.firebase.google.com/
2. enable firestore in firebase console
3. change the security rules to "allow read, write: if true;"
4. add new android project in firebase console
5. follow the steps shown there to download and add the google-services.json file

To add google-services.json you need to switch to project view from android view,
You can do this from top left corner, click on the dropdown beside "android" & change it to project

Very Very Important Note : Step 3 is for educational purpose only & you should never leave it to
"if true", it is really unsecure & may incur unwanted billings.
change it to secure rules later by following the docs here : https://firebase.google.com/docs/firestore/security/get-started

That's All! Happy Coding*/

class MainActivity : AppCompatActivity() {

    private lateinit var fruitsBtn: MaterialButton
    private lateinit var vegetablesBtn: MaterialButton
    private lateinit var othersBtn: MaterialButton

    private lateinit var nameEt: EditText
    private lateinit var fruitRadio: RadioButton
    private lateinit var vegetableRadio: RadioButton
    private lateinit var otherRadio: RadioButton
    private lateinit var addBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        fruitsBtn.setOnClickListener { showList(Item.fruitsType) }
        vegetablesBtn.setOnClickListener { showList(Item.vegetablesType) }
        othersBtn.setOnClickListener { showList(Item.othersType) }

        addBtn.setOnClickListener { add() }
    }

    private fun initViews() {
        fruitsBtn = findViewById(R.id.fruits_btn)
        vegetablesBtn = findViewById(R.id.vegetables_btn)
        othersBtn = findViewById(R.id.others_btn)

        nameEt = findViewById(R.id.name_et)
        fruitRadio = findViewById(R.id.fruit_radio)
        vegetableRadio = findViewById(R.id.vegetable_radio)
        otherRadio = findViewById(R.id.other_radio)
        addBtn = findViewById(R.id.add_btn)
    }

    //Prepare Intent, put extra data & start the activity
    private fun showList(type: String) {
        val listIntent = Intent(this, ListActivity::class.java)
        listIntent.putExtra("type", type)
        startActivity(listIntent)
    }

    //This method does the following :
    // 1. collects the data from layout
    // 2. perform pre-checks
    // 3. prepare the data to be uploaded
    // 4. call firestore method
    private fun add() {
        val type = when {
            fruitRadio.isChecked -> Item.fruitsType
            vegetableRadio.isChecked -> Item.vegetablesType
            otherRadio.isSelected -> Item.othersType
            else -> null
        }

        if (type == null) {
            Toast.makeText(this, "Please select type", Toast.LENGTH_LONG).show()
            return
        }

        val name = nameEt.text.toString()

        if (name.isBlank()) {
            Toast.makeText(this, "Please enter name", Toast.LENGTH_LONG).show()
            return
        }

        //Prepare the object
        val item = Item()
        item.name = name
        item.type = type

        //Upload/Write to the firestore
        writeDataToFirestore(item)
    }

    //this is the method responsible for writing data to the firestore
    private fun writeDataToFirestore(item: Item) {
        val db = FirebaseFirestore.getInstance()

        db.collection("Items")
            .document()   //creates a new doc
            .set(item)    //write
            .addOnSuccessListener {
                Toast.makeText(this, "Successfully Written", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                it.printStackTrace()
            }
    }

}