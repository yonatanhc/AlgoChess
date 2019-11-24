package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.AtaqueDeSoldado;

public class Soldado extends Unidad {

    public Soldado(){
        super(100,1);
        this.nombreDeUnidad = "Soldado";
    }


    public void activarHabilidad(){
        asignarTipoDeHabilidad(new AtaqueDeSoldado(getTablero()));
        getTipoDeHabilidad().activarHabilidad(this);
    }





}