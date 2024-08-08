package com.example.lab_1_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ProductArrayAdapter extends ArrayAdapter<Product> {
    private Context contextp;
    private int resource;
    private ArrayList<Product> ArrayLstOfProducts;


    public ProductArrayAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.contextp=context;
        this.resource=resource;
        this.ArrayLstOfProducts=(ArrayList<Product>) objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Product P = this.ArrayLstOfProducts.get(position);

        convertView = LayoutInflater.from(this.contextp).inflate(this.resource,
                parent,false);

        ImageView Imageprod=(ImageView) convertView.findViewById(R.id.idPimg);
        TextView Desprod=(TextView) convertView.findViewById(R.id.idTextDesc);
        TextView Prixprod=(TextView) convertView.findViewById(R.id.idTextPrix);
        Button Btnajouter=(Button) convertView.findViewById(R.id.idBtnAjouterP);

      Imageprod.setImageResource(P.getImg());
      Desprod.setText(P.getDesc());
      Prixprod.setText(String.valueOf(P.getPrix())+" $");
      Btnajouter.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
             if(Cart.ProduitsAjouter.contains(P)==true){
                 P.PlusQuantiteClient();
             }else{

                      Cart.ProduitsAjouter.add(P);
              }
          }
      });

        return convertView ;
    }
}
