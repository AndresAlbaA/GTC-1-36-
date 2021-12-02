package com.example.autopartscolv10;

import android.os.Parcel;
import android.os.Parcelable;

public class Producto implements Parcelable {
    private String nombreProd;
    private int precio;
    private int id;
    private int imagen;

    public Producto(int id, String nombreProd, int precio, int imagen) {
        this.id = id;
        this.nombreProd = nombreProd;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int arg1) {
        dest.writeInt(id);
        dest.writeString(nombreProd);
        dest.writeInt(precio);
        dest.writeInt(imagen);
    }

    public Producto(Parcel in){
        id = in.readInt();
        nombreProd = in.readString();
        precio = in.readInt();
        imagen = in.readInt();
    }

    public static final Parcelable.Creator<Producto> CREATOR  = new Parcelable.Creator<Producto>(){
        public Producto createFromParcel(Parcel in){
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };
}
