package com.example.lab_1_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ArrayList<Product> ArrayLstOfProducts;
    private ProductArrayAdapter  ProductArrayAdapter;
private Button btnPanier;
private Context contextp;
private ListView LstAchat;
private MarketDb marketDb;
private TextView idCategories;
String cat;

    private void Print(String cat) {
        try {
            this.marketDb=new MarketDb(contextp,"panier",null,1);
            this.marketDb.OpenDb();
            this.ArrayLstOfProducts=new ArrayList<Product>();
            this.ArrayLstOfProducts=this.marketDb.RecupCategorie(cat);
            if(this.ArrayLstOfProducts.size()<1){

                this.marketDb.AjoutProduits();
                this.ArrayLstOfProducts=this.marketDb.RecupCategorie(cat);
            }

            this.ProductArrayAdapter=new ProductArrayAdapter(this,R.layout.achat_produit,this.ArrayLstOfProducts);
            this.LstAchat.setAdapter(this.ProductArrayAdapter);
            this.marketDb.close();
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.btnPanier=(Button) findViewById(R.id.btnPanier);
        this.idCategories=(TextView) findViewById(R.id.idCategories);
        this.LstAchat=(ListView) findViewById(R.id.LstAchat);
        this.contextp = this;
        Bundle contains= getIntent().getExtras();
        if(contains!=null){

            this.cat=contains.getString("Categorie");
        }
        this.idCategories.setText(cat);
         Print(cat);
         this.btnPanier.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent i =new Intent(getApplicationContext(),MainActivity3.class);
                 startActivity(i);
             }
         });
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