package com.example.lab_1_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private CartArrayAdapter CartArrayAdapter;

private ArrayList<Product>    ArrayLstOfProducts;

private ListView CartlstV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.CartlstV=(ListView) findViewById(R.id.CartlstV);
        ArrayLstOfProducts=Cart.ProduitsAjouter;
        this.CartArrayAdapter=new CartArrayAdapter(this,R.layout.paiement_produits, ArrayLstOfProducts);
        this.CartlstV.setAdapter(CartArrayAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater minf=getMenuInflater();
        minf.inflate(R.menu.main_menu,menu);

        return true;

    }

    private boolean menu(Menu menu) {

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        Intent I;
        I=new Intent(this,MainActivity.class);
        startActivity(I);
        return true;
    }

}