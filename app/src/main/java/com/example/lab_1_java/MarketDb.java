package com.example.lab_1_java;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MarketDb extends SQLiteOpenHelper {

    private  Context context;
    private SQLiteDatabase Db;

    public MarketDb (Context context,String name, SQLiteDatabase.CursorFactory factory,int version ){
        super(context,name,factory,version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CategoryReq="CREATE TABLE IF NOT EXISTS categories (id_categories integer primary key Autoincrement,nom_categories text);";
        db.execSQL(CategoryReq);
        String ProduitReq="CREATE TABLE IF NOT EXISTS produits(id_produit integer primary key Autoincrement,nom_produit text ,quantite_prod integer,description_produit text,prix_produits text,img text, nom_categories text,FOREIGN KEY(nom_categories) REFERENCES categories(nom_categories));";
        db.execSQL(ProduitReq);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       String  CategoryReq= "DROP TABLE IF EXISTS categories ;";
       db.execSQL(CategoryReq);
       String ProduitReq="DROP TABLE IF EXISTS produits;";
        db.execSQL(ProduitReq);
       onCreate(db);
    }
    public void OpenDb(){this.Db=this.getReadableDatabase();}

    public void CloseDb(){this.Db.close();}


    public void AjoutCategories(){
        this.Db.execSQL("Insert into categoriess(nom_categories) values('Fruits');");
        this.Db.execSQL("Insert into categoriess(nom_categories) values('Legumes');");
        this.Db.execSQL("Insert into categoriess(nom_categories) values('Viandes');");
        this.Db.execSQL("Insert into categoriess(nom_categories) values('Jus');");
        this.Db.execSQL("Insert into categoriess(nom_categories) values('Fromages');");
    }
    public void AjoutProduits(){

        String imgFrpom=String.valueOf(R.drawable.pomme);
        String imgFrpoi=String.valueOf(R.drawable.poire);
        String imgFrr=String.valueOf(R.drawable.raisin);
        String imgFrpech=String.valueOf(R.drawable.peche);
        String imgLper=String.valueOf(R.drawable.persil);
        String imgLt=String.valueOf(R.drawable.tomate);
        String imgLpoiv=String.valueOf(R.drawable.poivron);
        String imgLcar=String.valueOf(R.drawable.carrot);
        String imgFmout=String.valueOf(R.drawable.mozarella);
        String imgFchevr=String.valueOf(R.drawable.parmesan);
        String imgFvache=String.valueOf(R.drawable.camembert);
        String imgVm=String.valueOf(R.drawable.mouton);
        String imgVpigeon=String.valueOf(R.drawable.lapin);
        String imgVboeuf=String.valueOf(R.drawable.vache);
        String imgVdinde=String.valueOf(R.drawable.dinde);
        String imgJoran=String.valueOf(R.drawable.jus_orange);
        String imgJfraise=String.valueOf(R.drawable.jus_fraise);
        String imgJrais=String.valueOf(R.drawable.jus_pommme);
        String imgJmix=String.valueOf(R.drawable.cocktail);




        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Pomme',153,'la Pomme est un fruit qui aide a dormir',3.5,'"+imgFrpom+"','Fruits')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Poire',150,'le Poire est un fruit qui est tres bon',4.0,'"+imgFrpoi+"','Fruits')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Peche',152,'la Peche est un fruit qui aide a dormir',2.5,'"+imgFrpoi+"','Fruits')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Avocat',155,'l`Avocat est un fruit qui aide a dormir',1.59,'"+imgFrpech+"','Fruits')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Papaye',154,'la Papaye est un fruit qui aide a dormir',9.66,'"+imgFrr+"','Fruits')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Tomate',153,'la Tomate est un Legumes qui aide a dormir',3.99,'"+imgLt+"','Legumes')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Poivron',135,'le Poivron est un Legumes qui aide a dormir',2.66,'"+imgLpoiv+"','Legumes')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Oignon',125,'l`Oignon est un Legumes qui aide a dormir',5.55,'"+imgLcar+"','Legumes')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Carrote',135,'la Carrote est un Legumes qui aide a dormir',3.80,'"+imgLcar+"','Legumes')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Persil',105,'le Persil est un Legumes qui aide a dormir',1.5,'"+imgLper+"','Legumes')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Courgette',105,'la Courgette est un Legumes qui aide a dormir',2.56,'"+imgLper+"','Legumes')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Ail',150,'l`Ail est un Legumes qui aide a dormir',1.22,'"+imgLcar+"','Legumes')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Pomme',145,'le jus de Pomme est un jus qui aide a dormir',3.0,'"+imgJrais+"','Jus')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Raisin',19,'le jus de Raisin est un jus qui aide a dormir',4.5,'"+imgJrais+"','Jus')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Coktail',37,'le jus de Coktail est un jus qui aide a dormir',5.57,'"+imgJfraise+"','Jus')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Mangue',100,'le jus de Mangue est un jus qui aide a dormir',3.58,'"+imgJoran+"','Jus')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Annanas',25,'le jus de Annanas est un jus qui aide a dormir',3.5,'"+imgJoran+"','Jus')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Lapin',15,'la  viande de Lapin est une viande qui aide a dormir',10.5,'"+imgVpigeon+"','Viandes')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Poulet',65,'la  viande de Poulet est une viande qui aide a dormir',8.60,'"+imgVpigeon+"','Viandes')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Boeuf',17,'la viande de Boeuf est une viande qui aide a dormir',7.99,'"+imgVboeuf+"','Viandes')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Mouton',25,'la viande de Mouton est une viande qui aide a dormir',13.55,'"+imgVm+"','Viandes')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Naturel',35,'le fromage de Naturel est une viande qui aide a dormir',6.5,'"+imgFmout+"','Fromages')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Vaches',19,'le fromage de Vaches est un fromage qui aide a dormir',2.5,'"+imgFchevr+"','Fromages')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Mouton',45,'le fromage de Mouton est un fromage qui aide a dormir',6.90,'"+imgFchevr+"','Fromages')");
        this.Db.execSQL("INSERT INTO produits(nom_produit,quantite_prod,description_produit,prix_produits,img,nom_categories) values('Chevre',30,'le fromage de Chevre est un fromage qui aide a dormir',8.5,'"+imgFvache+"','Fromages')");

    }
    public ArrayList<Product> RecupCategorie(String nomchoix){
        ArrayList<Product> LstProductSelected= new ArrayList<Product>();
        Cursor C = this.Db.rawQuery("select *from produits where nom_categories ='"+nomchoix+"'", null);

        int PosiIdProd=C.getColumnIndex("id_produit");
        int PosiNomProd=C.getColumnIndex("nom_produit");
        int PosiQuantiteProd = C.getColumnIndex("quantite_prod");
        int PosiDescriptProd = C.getColumnIndex("description_produit");
        int PosiPrixProd = C.getColumnIndex("prix_produits");
        int PosiImageProd=C.getColumnIndex("img") ;
        int PosiNomCat = C.getColumnIndex("nom_categories");


        if ((C!= null) && C.moveToFirst())
        {

            do{
                LstProductSelected.add(new Product(C.getInt(PosiIdProd),C.getString(PosiNomProd),C.getInt(PosiQuantiteProd),C.getString(PosiDescriptProd),C.getDouble(PosiPrixProd),C.getInt(PosiImageProd),C.getString(PosiNomCat)));
            }while(C.moveToNext());

        }
        return LstProductSelected;

    }

}
