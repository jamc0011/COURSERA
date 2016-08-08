package com.jamc0011.coursera.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jamc0011.coursera.db.ConstructorPerros;
import com.jamc0011.coursera.pojo.Perro;
import com.jamc0011.coursera.R;

import java.util.ArrayList;


public class PerroAdapter extends RecyclerView.Adapter<PerroAdapter.PerroViewHolder>{
    ArrayList<Perro>      perros;
    Activity              activity;

    public PerroAdapter(ArrayList<Perro> perros, Activity activity) {
        this.perros = perros;
        this.activity = activity;
    }

    @Override
    public PerroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perro, parent, false);
        return new PerroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PerroViewHolder perroViewHolder, int position) {
        final Perro perro = perros.get(position);

        perroViewHolder.imageViewFoto.setImageResource(perro.getFoto());
        perroViewHolder.textViewNombre.setText(perro.getNombre());
        perroViewHolder.tvLikes.setText(String.valueOf(perro.getLikes())+ " Likes");

        perroViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Me gusta " + perro.getNombre(),
                        Toast.LENGTH_SHORT).show();


                ConstructorPerros constructorPerros = new ConstructorPerros(activity);
                constructorPerros.darLikePerro(perro);
                perroViewHolder.tvLikes.setText(constructorPerros.obtenerLikesPerro(perro) + " " + activity.getString(R.string.likes));
            }
        });
    }

    @Override
    public int getItemCount() {
        return perros.size();
    }

    public static class PerroViewHolder extends RecyclerView.ViewHolder {

        private ImageView       imageViewFoto;
        private TextView        textViewNombre;
        private ImageButton     btnLike;
        private TextView        tvLikes;


        public PerroViewHolder(View itemView){
            super(itemView);
            imageViewFoto=(ImageView) itemView.findViewById(R.id.imageViewFotoPerroCardView);
            btnLike= (ImageButton) itemView.findViewById(R.id.btnLike);
            textViewNombre=(TextView) itemView.findViewById(R.id.textViewNombrePerroCardView);
            tvLikes= (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }
}
