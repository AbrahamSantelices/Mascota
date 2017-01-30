package com.example.peluzo.mascota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascota;
    private RecyclerView listaMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascota = (RecyclerView) findViewById(R.id.rvMascota);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        listaMascota.setLayoutManager(llm);
        icializarListaMascota();
        inicializarAdaptador();

    }

    public void icializarListaMascota(){
        mascota = new ArrayList<Mascota>();

        mascota.add(new Mascota(R.drawable.coraje,"Coraje","1"));
        mascota.add(new Mascota(R.drawable.flash,"Flash","4"));
        mascota.add(new Mascota(R.drawable.huesos,"Huesos","3"));
        mascota.add(new Mascota(R.drawable.odie,"Odie","5"));
        mascota.add(new Mascota(R.drawable.pch,"Peche","5"));

    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascota,this);
        listaMascota.setAdapter(adaptador);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_estrella:
                accionEstrlla();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void accionEstrlla(){
        Intent intent = new Intent(this, DetalleMascota.class);
        startActivity(intent);

    }


}
