package com.wmtbr.entregavel02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wmtbr.entregavel02.model.Receita;

import java.util.ArrayList;
import java.util.List;

public class Receitas_Activity extends Activity implements ItemClickListener {

        private RecyclerView mRecyclerView;
        private ReceitasAdapter mAdapter;
        private List<Receita> listaReceita;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.seganda_activity);

            mRecyclerView = (RecyclerView)findViewById(R.id.lista);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());

            //Inicializando a lista de itens que vão para o Recycler
            listaReceita = new ArrayList<>();

            //Criando um objeto receita para inserir na lista
            Receita r1 = new Receita("Bolo", "@drawable/pannacota");

            //Passando o objeto Receita para a lista de receitas
            listaReceita.add(r1);

            //Passando a lista já com o objeto para o adapter
            mAdapter = new ReceitasAdapter(listaReceita);
            mAdapter.setClickListener(this);

            mRecyclerView.setAdapter(mAdapter);

        }

        @Override
        public void onClick(View view, int position) {
            Receita receitas = listaReceita.get(position);
            Intent i = new Intent(view.getContext(), X.class);
            //i.putExtra("rec", receitas.name);
            //i.putExtra("desc", receitas.description);
            //i.putExtra("image", receitas.imageName);
            startActivity(i);
        }
    }

