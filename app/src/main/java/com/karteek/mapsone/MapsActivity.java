package com.karteek.mapsone;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends Activity implements OnMapReadyCallback {

    static final LatLng NEWARK = new LatLng(40.735188, -74.172414);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapFragment mapFragment = (MapFragment)getFragmentManager().
                findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(NEWARK).
                draggable(true));
        map.setOnMarkerDragListener(new GoogleMap.
                OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
                Toast.makeText(getApplicationContext(),"Drag started",Toast.LENGTH_SHORT).show();
            }
            public void onMarkerDrag(Marker marker) {
                Log.d("Drag","Dragging");
            }
            @Override
            public void onMarkerDragEnd(Marker marker) {
                Log.d("Drag","Drag ended");
                LatLng latLng = marker.getPosition();
                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;
                Toast.makeText(getApplicationContext(),"Latitude : "+latitude+"\nLongitude : "+longitude,Toast.LENGTH_LONG).show();
            }
        });
    }
}