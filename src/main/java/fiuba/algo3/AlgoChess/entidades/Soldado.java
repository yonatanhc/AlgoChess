package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.Ataque;
import fiuba.algo3.AlgoChess.acciones.RangoCorto;

public class Soldado extends Unidad {

    public Soldado(){
        super(100,1);
        this.nombreDeUnidad = "Soldado";

    }

    public void asignarHabilidad(){
        asignarTipoDeHabilidad(new Ataque(new RangoCorto(getTablero()),0,20));
    }

    public void activarHabilidad(){
        getTipoDeHabilidad().activarHabilidad(this);
    }



}