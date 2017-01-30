package com.example.peluzo.mascota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DetalleMascota extends AppCompatActivity {

    ArrayList<Mascota> mascotaDetalle;
    private RecyclerView listaMascotaDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotaDetalle = (RecyclerView) findViewById(R.id.rvMascotaDetalle);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        listaMascotaDetalle.setLayoutManager(llm);
        icializarListaMascota();
        inicializarAdaptador();

    }

    public void icializarListaMascota(){
        mascotaDetalle = new ArrayList<Mascota>();

        mascotaDetalle.add(new Mascota(R.drawable.pch,"Peche","5"));
        mascotaDetalle.add(new Mascota(R.drawable.odie,"Odie","5"));
        mascotaDetalle.add(new Mascota(R.drawable.flash,"Flash","5"));
        mascotaDetalle.add(new Mascota(R.drawable.coraje,"Coraje","5"));
        mascotaDetalle.add(new Mascota(R.drawable.huesos,"Huesos","5"));



    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotaDetalle,this);
        listaMascotaDetalle.setAdapter(adaptador);

    }

}
