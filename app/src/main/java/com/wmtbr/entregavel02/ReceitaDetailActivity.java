package com.wmtbr.entregavel02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ReceitaDetailActivity extends AppCompatActivity {

    public static final String city = "city";
    public static final String desc = "desc";
    public static final String image = "image";

        private TextView tvReceitaName;
        private TextView tvReceitaDescricao;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_receita_view);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setBackground(getResources().getDrawable(getResources().getIdentifier(getIntent().getStringExtra("image"), "drawable", getPackageName())));

            tvReceitaName = (TextView) findViewById(R.id.tv_city_name);
            tvReceitaName.setText(getIntent().getStringExtra("city"));
            tvReceitaDescricao = (TextView) findViewById(R.id.tv_city_desc);
            tvReceitaDescricao.setText(getIntent().getStringExtra("desc"));

        }
}
