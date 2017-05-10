package com.sandra.xcavapp;


import android.*;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sandra.xcavapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapaR2Fragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;

    public MapaR2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false); //Ya no retorna si no q la almaceno en alguna parte para poderla manejar, por eso se hace en objeto tipo View

        mapView = (MapView) view.findViewById(R.id.map); //Con este ya puedo acceder a la info q yo quiero, en este caso el mapa
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);     //Sincronizamos para cargar el mapa...

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            return;
        }

        mMap.setMyLocationEnabled(true);    //Activa la geolocalización

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //Cambia el tipo de mapa q estoy usando

        // Add a marker in Sydney and move the camera
        /*LatLng SArma = new LatLng(6.1771331,-75.4398934);
        mMap.addMarker(new MarkerOptions().position(SArma).title("Santiago de Arma"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SArma,12));*/
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }
}
