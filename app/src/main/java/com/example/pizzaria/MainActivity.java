package com.example.pizzaria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btpagar, btLimpar;
    double total;
    String saida, txtpizza;
    CheckBox ckcalabresa, ckpalmito, ckmargarita, ck4queijos, ckmodadacasa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btLimpar = findViewById(R.id.btnLimpar);
        btpagar = findViewById(R.id.btnpagar);
        ckcalabresa = findViewById(R.id.ckcalabresa);
        ckpalmito = findViewById(R.id.ckpalmito);
        ckmargarita = findViewById(R.id.ckmargarita);
        ckmodadacasa = findViewById(R.id.ckmodacasa);
        ck4queijos = findViewById(R.id.ck4queijos);
        btLimpar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
            total=0;
            txtpizza="";
            ckcalabresa.setChecked(false);
            ckpalmito.setChecked(false);
            ckmargarita.setChecked(false);
            ck4queijos.setChecked(false);
            ckmodadacasa.setChecked(false);
            }
                                       });
        btpagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                total = 0;
                txtpizza="";
                if (ckcalabresa.isChecked()) {
                    total += 70;
                    txtpizza +="Calabresa\n";}
                if (ckpalmito.isChecked()){
                    total += 70;
                    txtpizza += "Palmito\n";}
                if (ckmargarita.isChecked()) {
                    total += 70;
                    txtpizza += "Margarita\n";}
                if (ck4queijos.isChecked()){
                    total += 85;
                    txtpizza +="4 Queijos\n";}
                if (ckmodadacasa.isChecked()){
                    total += 85;
                    txtpizza += "Moda da casa\n";}
                String msg = String.format("Total Pedido= $%5.2f", total);
                Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
                Intent it = new Intent(getBaseContext(),Pagamento.class);
                Bundle params = new Bundle();
                params.putString("pizzas",txtpizza);  // repare que pizzas é o primeiro parametro
                params.putDouble("total",total);
                it.putExtras(params);
                startActivity(it);
            }
        });
    }
}