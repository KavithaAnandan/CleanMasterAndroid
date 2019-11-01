package com.cleanmaster.appmodules.cleaningscreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.AutocompleteActivity
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import java.util.*


class CleaningScreen : FragmentActivity(), OnMapReadyCallback {
    private val AUTOCOMPLETE_REQUEST_CODE: Int = 0
    lateinit var gMap: GoogleMap
    var place1: AutocompleteSupportFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.cleanmaster.R.layout.activity_cleaning)
        initViews()

    }

    private fun initViews() {
        val mapFragment = supportFragmentManager
            .findFragmentById(com.cleanmaster.R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)

        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), "AIzaSyDKymeBXNeiFWY5jRUejv6zItpmr2MVyQ0");
        }

        val fields = Arrays.asList(Place.Field.ID, Place.Field.NAME)
        // Start the autocomplete intent.
        var intent = Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields).build(
            this
        )
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    var place = data?.let { Autocomplete.getPlaceFromIntent(it) };
                    if (place != null) {
                        Log.i("Places:::", "Place:::" + place.name + ", " + place.id)
                    }
                }
                AutocompleteActivity.RESULT_ERROR -> {
                    var status = data?.let { Autocomplete.getStatusFromIntent(it) };
                    if (status != null) {
                        Log.i("ERROR MESSAGE :::", status.statusMessage)
                    }
                }
                Activity.RESULT_CANCELED -> {
                    Log.i("ERROR MESSAGE :::", "User has cancelled the operation")

                }
            }

        }
    }

    override fun onMapReady(map: GoogleMap?) {
        gMap = map!!
        if (gMap != null) {
            gMap.isMyLocationEnabled = true
        }
    }

}