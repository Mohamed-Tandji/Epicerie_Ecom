package com.example.lab_1_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

//        public void onClick(View v){
//        try{
//            MyDbAdapter myDbAdapter = new MyDbAdapter((getApplicationContext());
//            myDbAdapter.Open();
//            myDbAdapter.InsertProd("");
//    }catch(Exception ex){
//        }
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       super.onCreateOptionsMenu(menu);
//        MenuInflater minf= getMenuInflater();
//        minf.inflate(R.menu.main_menu,menu);
//        return true;

       MenuItem pmi1= menu.add(Menu.NONE,Menu.FIRST+0,0,"Fruits");
       MenuItem pmi2= menu.add(Menu.NONE,Menu.FIRST+1,1,"Legumes");
       MenuItem pmi3= menu.add(Menu.NONE,Menu.FIRST+2,2,"Viandes");
       MenuItem pmi4= menu.add(Menu.NONE,Menu.FIRST+3,3,"Jus");
       MenuItem pmi5= menu.add(Menu.NONE,Menu.FIRST+4,4,"Fromages");


        return menu(menu);

    }

    private boolean menu(Menu menu) {

        return  true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return ChoixCat(item);
    }

    public boolean ChoixCat(MenuItem item) {
        super.onOptionsItemSelected(item);
        Intent choix;
     
        switch (item.getItemId()) {
            case Menu.FIRST:
               // Toast.makeText(this, "Fruit", Toast.LENGTH_LONG).show();
                choix= new Intent(this, MainActivity2.class);
                choix.putExtra("Categorie","Fruits");
                startActivity(choix);
                return true;

            case Menu.FIRST+1:
              //  Toast.makeText(this, "Legumes", Toast.LENGTH_LONG).show();
                choix= new Intent(this, MainActivity2.class);
                choix.putExtra("Categorie","Legumes");
                startActivity(choix);
                return true;
            case Menu.FIRST+2:
              //  Toast.makeText(this, "Viandes", Toast.LENGTH_LONG).show();
                choix= new Intent(this, MainActivity2.class);
                choix.putExtra("Categorie","Viandes");
                startActivity(choix);
                return true;
            case Menu.FIRST+3:
               // Toast.makeText(this, "jus", Toast.LENGTH_LONG).show();
                choix= new Intent(this, MainActivity2.class);
                choix.putExtra("Categorie","Jus");
                startActivity(choix);
                return true;
            case Menu.FIRST+4:
                //Toast.makeText(this, "Fromages", Toast.LENGTH_LONG).show();
                choix= new Intent(this, MainActivity2.class);
                choix.putExtra("Categorie","Fromages");
                startActivity(choix);
                return true;

        }

        return true;
    }
}
