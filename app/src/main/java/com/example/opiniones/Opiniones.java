package com.example.opiniones;

import java.util.ArrayList;

public class Opiniones {

    private ArrayList <String> listaOpiniones = new ArrayList<>();
    private ArrayList <String> listaUsuarios = new ArrayList<>();

    public Opiniones() {

        listaOpiniones.add("Clásico, entretenido");
        listaOpiniones.add("Clásico, referente cultural");
        listaOpiniones.add("Clásico, introspectivo");
        listaOpiniones.add("Cultura POP años 80");
        listaOpiniones.add("Mitología");

        listaUsuarios.add("User1");
        listaUsuarios.add("User2");
        listaUsuarios.add("User3");
        listaUsuarios.add("User4");
        listaUsuarios.add("User5");

    }

    public String getOpinion (int pos){

        return listaOpiniones.get(pos).toString();

    }

    public String getUser (int pos){

        return listaUsuarios.get(pos).toString();

    }

    public void reescribirOpi(int pos, String opi){

        listaOpiniones.set(pos, opi);
        System.out.println(listaOpiniones.get(pos));

    }

    public void reescribirUser(int pos, String user){

        listaUsuarios.set(pos, user);
    }

    public ArrayList devolverArrayListOpis(){

        return listaOpiniones;
    }



}
