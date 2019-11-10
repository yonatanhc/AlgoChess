package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.Curar;
import fiuba.algo3.AlgoChess.acciones.RangoCorto;

public class Curandero extends Unidad {


    public Curandero(){
        super(75,2);
        this.nombreDeUnidad = "Curandero";

    }

    public void asignarHabilidad(){
        asignarTipoDeHabilidad(new Curar(new RangoCorto(getTablero()),15));
    }

    public void activarHabilidad(){
        getTipoDeHabilidad().activarHabilidad(this);
    }




}