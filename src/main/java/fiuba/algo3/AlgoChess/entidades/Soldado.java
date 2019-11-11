package fiuba.algo3.AlgoChess.entidades;

public class Soldado extends Unidad {

    public Soldado(){
        super(100,1);
        this.nombreDeUnidad = "Soldado";

    }

    public void activarHabilidad(){
        asignarTipoDeHabilidad(new Ataque(new RangoCorto(getTablero()),0,20));
        getTipoDeHabilidad().activarHabilidad(this);
    }



}