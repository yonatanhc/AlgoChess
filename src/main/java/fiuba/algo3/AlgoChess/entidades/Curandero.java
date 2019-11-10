package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.Ataque;
import fiuba.algo3.AlgoChess.acciones.RangoCorto;
import fiuba.algo3.AlgoChess.acciones.RangoMedio;

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