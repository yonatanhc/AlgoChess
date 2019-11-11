package fiuba.algo3.AlgoChess.entidades;

public class Catapulta extends Unidad {


    public Catapulta(){
        super(50,5);
        this.nombreDeUnidad = "Catapulta";
    }

    public void activarHabilidad(){
        asignarTipoDeHabilidad(new Ataque(new RangoLargo(getTablero()),0,20));
        getTipoDeHabilidad().activarHabilidad(this);
    }

}