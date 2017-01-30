package com.example.peluzo.mascota;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by peluzo on 26/01/17.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewholder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascota, Activity activity){
        this.mascotas = mascota;
        this.activity = activity;
    }


    @Override
    public MascotaViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewholder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewholder mascotaViewholder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewholder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewholder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewholder.tvRaitingCV.setText(mascota.getRaiting());


        mascotaViewholder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getNombre(),Toast.LENGTH_SHORT).show();

                /*Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("email",contacto.getEmail());
                activity.startActivity(intent);*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewholder extends RecyclerView.ViewHolder{

        private TextView tvNombreCV, tvRaitingCV;
        private ImageView imgFotoCV;

        public MascotaViewholder(View itemView) {
            super(itemView);

            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRaitingCV = (TextView) itemView.findViewById(R.id.tvRaitingCV);
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCV);

        }
    }
}
