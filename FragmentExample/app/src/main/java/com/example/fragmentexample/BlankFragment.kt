package com.example.fragmentexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BlankFragment : Fragment() {

    private val TAG = "BlankFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank, container, false)

        //All other methods are not mandatory, they can used only when required
        //Here, they are written to explain Fragment's Lifecycle

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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