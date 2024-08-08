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

public class CartArrayAdapter extends ArrayAdapter<Product> {
    private Context contextC;
    private int resourceC;
    private ArrayList<Product> ArrayLstOfProducts;

    public CartArrayAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);

        this.contextC=context;
        this.resourceC=resource;
        this.ArrayLstOfProducts= new ArrayList<Product>();
        this.ArrayLstOfProducts=(ArrayList<Product>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Product Pc= this.ArrayLstOfProducts.get(position);
        convertView = LayoutInflater.from(this.contextC).inflate(this.resourceC,
                parent,false);
        ImageView Img=(ImageView) convertView.findViewById(R.id.idPimg);
        TextView Qte=(TextView) convertView.findViewById(R.id.txtQte);
        Button BtnD=(Button) convertView.findViewById(R.id.idSupprimer);
        Button BtnP=(Button) convertView.findViewById(R.id.idBtnAugmenterQ);
        Button BtnM=(Button) convertView.findViewById(R.id.idBtnReduireQ);

        Img.setImageResource(Pc.getImg());
        Qte.setText(String.valueOf(Pc.getQteClient()));
        BtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(Pc);
                notifyDataSetChanged();
            }
        });
        BtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pc.PlusQuantiteClient();
                Qte.setText(String.valueOf(Pc.getQteClient()));

            }
        });
        BtnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pc.MoinsQuantiteClient();
                Qte.setText(String.valueOf(Pc.getQteClient()));

            }
        });



        return convertView;
    }
}
