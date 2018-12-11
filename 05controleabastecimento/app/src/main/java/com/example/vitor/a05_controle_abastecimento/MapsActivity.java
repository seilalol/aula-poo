package com.example.vitor.a05_controle_abastecimento;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.concurrent.ExecutionException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        abastecimentoAdapter novo = new abastecimentoAdapter();
        novo.listaPostos = abastecimentoDAO.getLista(this.getApplicationContext());
        // Add a marker in Sydney and move the camera
        try {
            int i, ultimo=0;
            for(i=0;novo.listaPostos.get(i)!=null;i++) {
                Posto posto = novo.listaPostos.get(i);
                    LatLng add = new LatLng(posto.getLatitude(), posto.getLongitude());

                    mMap.addMarker(new MarkerOptions().position(add).title("Posto abastecido"));
                    ultimo = i;
                    }
            LatLng centralizar = new LatLng(novo.listaPostos.get(ultimo).getLatitude(), novo.listaPostos.get(ultimo).getLongitude());
            mMap.moveCamera(CameraUpdateFactory.newLatLng(centralizar));
        }catch (Exception e){}

    }

}
