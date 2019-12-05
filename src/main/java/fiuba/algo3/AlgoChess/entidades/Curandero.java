package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.Curar;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;


public class Curandero extends Unidad {

    public Curandero(){
        super(75,2);
        this.nombreDeUnidad = "Curandero";

    }

    public void activarHabilidad() {
        asignarTipoDeHabilidad(new Curar(getTablero()));
        getTipoDeHabilidad().activarHabilidad(this);
    }

    @Override
    public void moverUnidad(Casillero destino) {
        getUbicacion().cambiarEstadoDelCasilleroALibre();
        setUbicacion(destino);
    }

}