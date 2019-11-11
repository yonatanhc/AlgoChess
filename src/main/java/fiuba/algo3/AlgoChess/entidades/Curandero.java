package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.Curar;
<<<<<<< HEAD
import fiuba.algo3.AlgoChess.acciones.RangoCorto;
=======
>>>>>>> ataque

public class Curandero extends Unidad {


    public Curandero(){
        super(75,2);
        this.nombreDeUnidad = "Curandero";
<<<<<<< HEAD

    }

    public void asignarHabilidad(){
        asignarTipoDeHabilidad(new Curar(new RangoCorto(getTablero()),15));
=======
>>>>>>> ataque
    }

    public void activarHabilidad() {
        asignarTipoDeHabilidad(new Curar(getTablero()));
        getTipoDeHabilidad().activarHabilidad(this);
    }

}