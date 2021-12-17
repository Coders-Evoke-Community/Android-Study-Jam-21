package com.example.fragmentexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //To add fragment to this activity, we have two options

        //Option 1 : add the "android:name="com.example.fragmentexample.BlankFragment"
        //           inside FragmentContainerView in the Activity's layout XML file

        //Option 2 : programmatically add a fragment to your activity's layout
        //           This way allows us to change the fragment dynamically
        supportFragmentManager.commit {
            replace(R.id.example_fragment, BlankFragment())
            addToBackStack("example")
        }

        Log.i(TAG, "onCreate: CUSTOM_CHECK")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: CUSTOM_CHECK")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: CUSTOM_CHECK")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: CUSTOM_CHECK")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: CUSTOM_CHECK")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: CUSTOM_CHECK")
    }

}