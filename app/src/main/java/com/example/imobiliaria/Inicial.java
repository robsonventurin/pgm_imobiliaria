package com.example.imobiliaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Inicial extends AppCompatActivity {

    ListView lView;
    ListAdapter lAdapter;

    final ArrayList<Imovel> imoveisComprar = new ArrayList<Imovel>();
    final ArrayList<Imovel> imoveisAlugar = new ArrayList<Imovel>();
    final ArrayList<Imovel> imoveisTrocar = new ArrayList<Imovel>();
    ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        imoveisComprar.add(new Imovel(R.drawable.casa1, "Casa Magnífica", (double) 150000, "Venda"));
        imoveisComprar.add(new Imovel(R.drawable.apartamento1, "Apartamento Top", (double) 200000, "Venda"));
        imoveisAlugar.add(new Imovel(R.drawable.rural1, "Área Rural", (double) 3000, "Aluguel"));
        imoveisTrocar.add(new Imovel(R.drawable.casatroca, "Super Casa", (double) 110000, "Troca"));

        lView = (ListView) findViewById(R.id.list);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Inicial.this, imoveis.get(i).getName() +" - "+ imoveis.get(i).getType(), Toast.LENGTH_SHORT).show();
            }
        });


        imoveis.addAll(imoveisAlugar);
        imoveis.addAll(imoveisComprar);
        imoveis.addAll(imoveisTrocar);
        lAdapter = new ListAdapter(Inicial.this, imoveis);
        lView.setAdapter(lAdapter);

    }

    public void showAlugar(View v) {
        imoveis = imoveisAlugar;
        lAdapter = new ListAdapter(Inicial.this, imoveisAlugar);
        lView.setAdapter(lAdapter);
    }

    public void showTrocar(View v) {
        imoveis = imoveisTrocar;
        lAdapter = new ListAdapter(Inicial.this, imoveisTrocar);
        lView.setAdapter(lAdapter);
    }

    public void showComprar(View v) {
        imoveis = imoveisComprar;
        lAdapter = new ListAdapter(Inicial.this, imoveisComprar);
        lView.setAdapter(lAdapter);
    }

    public void showTodos(View v) {
        imoveis.clear();
        imoveis.addAll(imoveisAlugar);
        imoveis.addAll(imoveisComprar);
        imoveis.addAll(imoveisTrocar);
        lAdapter = new ListAdapter(Inicial.this, imoveis);
        lView.setAdapter(lAdapter);
    }



}
