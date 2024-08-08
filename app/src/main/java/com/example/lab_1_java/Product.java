package com.example.lab_1_java;

public class Product {
    private  int Id;
    private String Nom;
    private int Qte;
    private String Desc;
    private double Prix;
    private int Img;
    private String Nom_Cat;
    private int QteClient=1;



    public Product(int id_produit, String  nom_produit, int quantite_prod, String description_produit, double prix_produits, int img, String nom_categories ){

        this.Id=id_produit;
        this.Nom=nom_produit;
        this.Qte=quantite_prod;
        this.Desc=description_produit;
        this.Prix=prix_produits;
        this.Img=img;
        this.Nom_Cat=nom_categories;
    }

    public int getId() { return Id;}

    public void setId(int id) { Id = id;}

    public String getNom() {return Nom;}

    public void setNom(String nom) {Nom = nom;}

    public int getQte() { return Qte; }

    public void setQte(int qte) { Qte = qte; }

    public String getDesc() { return Desc; }

    public void setDesc(String desc) {  Desc = desc; }

    public double getPrix() { return Prix;
    }

    public void setPrix(double prix) {
        Prix = prix;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getNom_Cat() {
        return Nom_Cat;
    }


    public void setNom_Cat(String nom_Cat) {
        Nom_Cat = nom_Cat;
    }
    public int getQteClient() {
        return QteClient;
    }

    public void setQteClient(int qteClient) {
        QteClient = qteClient;
    }
    public void PlusQuantiteClient()
    {

        if(this.QteClient < Qte){
                this.QteClient+=1;
        }
    }

    public void MoinsQuantiteClient()
    {
        if(this.QteClient > 1){

            this.QteClient-=1;
        }
    }









}

