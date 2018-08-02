package com.wmtbr.entregavel02;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wmtbr.entregavel02.model.Receita;

import java.util.ArrayList;
import java.util.List;

public class ReceitasAdapter extends RecyclerView.Adapter<ReceitasAdapter.ViewHolder>{

        private List<Receita> receitas;

        private ItemClickListener clickListener;

        public ReceitasAdapter(List<Receita> receitas) {
            this.receitas = receitas;

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_receita, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
           Receita r = this.receitas.get(position);
            viewHolder.bind(r.name, r.imageName);
        }

        @Override
        public int getItemCount() {
            return this.receitas == null ? 0 : this.receitas.size();
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public TextView cityName;
            public ImageView cityImage;
            Context c;

            public ViewHolder(View itemView) {
                super(itemView);
                cityName = (TextView) itemView.findViewById(R.id.receita_name);
                cityImage = (ImageView)itemView.findViewById(R.id.receita_image);
                c = itemView.getContext();
                itemView.setTag(itemView);
                itemView.setOnClickListener(this);
            }

            public void bind(String name, String imagem){

                int imageResource = c.getResources().getIdentifier(imagem, "drawable", c.getPackageName());
                Drawable res = ContextCompat.getDrawable(c.getApplicationContext(), imageResource);
                this.cityImage.setImageDrawable(res);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
            }
        }
    }

