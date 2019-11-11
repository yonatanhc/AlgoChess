package fiuba.algo3.AlgoChess.entidades;

public class Curandero extends Unidad {


    public Curandero(){
        super(75,2);
        this.nombreDeUnidad = "Curandero";

    }

    public void asignarHabilidad(){
        asignarTipoDeHabilidad(new Ataque(new RangoCorto(getTablero()),0,20));
    }

    public void activarHabilidad(){
        getTipoDeHabilidad().activarHabilidad(this);
    }




}