package com.example.pizzaria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Pagamento extends AppCompatActivity  {
    Button btvoltar;
    double total;
    TextView txtpagar;
    RadioGroup grupo;
    RadioButton rbpix,rbdinheiro, rbcartao;
    String saida, txtpizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        btvoltar = findViewById(R.id.btVoltar);
        btvoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   finish(); }
        });
        saida="";
        txtpagar = findViewById(R.id.edtpagar);
        Bundle params = getIntent().getExtras();
        if (params != null){
            txtpizza = params.getString("pizzas");  // repare que pizzas é o primeiro parâmetro recebido
            total = params.getDouble("total");
            txtpagar.setText(String.format("Total a Pagar $%5.2f",total));
        }
        grupo = findViewById(R.id.grupo);
        rbdinheiro = findViewById(R.id.rbDindin);
        rbpix = findViewById(R.id.rbPix);
        rbcartao = findViewById(R.id.rbCartao);

        saida=txtpizza.toString();
        grupo.setOnCheckedChangeListener(new  RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbdinheiro.isChecked()) saida+="\nPagamento em Dinheiro";
                else if (rbpix.isChecked()) saida+="\nPagamento via Pix";
                else saida+="\nPagamento através de Cartão";
                AlertDialog.Builder alerta = new AlertDialog.Builder(Pagamento.this);
                alerta.setIcon(R.drawable.minipizza2);
                alerta.setTitle("Forma de Pagamento");
                String textao = String.format("%s\nPreço R$%5.2f",saida,total);
                alerta.setMessage(textao);
                alerta.setNeutralButton("OK",null);
                alerta.show();
            }
        }); // final do evento OnCheckedChange
    } // final da classe Pagamento
    }
