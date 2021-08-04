package com.manriquetavi.mismapas;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.manriquetavi.mismapas.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        position = extras.getInt("position");
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng p1 = new LatLng(-13.417969906176912, -76.13333447971097);
        LatLng p2 = new LatLng(-13.417709912849299, -76.13230482495895);
        LatLng p3 = new LatLng(-13.417778406103029, -76.13506375861964);
        LatLng p4 = new LatLng(-13.417636999999988, -76.1352629);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.addMarker(new MarkerOptions().position(p1).title("Caffe Sport"));
        mMap.addMarker(new MarkerOptions().position(p2).title("Plaza de Armas Chincha"));
        mMap.addMarker(new MarkerOptions().position(p3).title("Caja Municipal Ica"));
        mMap.addMarker(new MarkerOptions().position(p4).title("Gelateria Calderon"));
        switch (position){
            case 0:
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p1,19));
                break;
            case 1:
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p2,19));
                break;
            case 2:
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p3,19));
                break;
            case 3:
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p4,19));
                break;
            default:
                break;
        }
    }
}