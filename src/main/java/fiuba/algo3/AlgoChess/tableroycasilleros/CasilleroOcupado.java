package fiuba.algo3.AlgoChess.tableroycasilleros;

import fiuba.algo3.AlgoChess.entidades.Unidad;

public class CasilleroOcupado implements EstadoDelCasillero {

    private Unidad unidad;


    public CasilleroOcupado(Unidad unidad) {
        this.unidad = unidad;
    }

    @Override
    public boolean estaLibre() {
        throw new CasilleroNoEstaLibreExcepcion();
    }

    @Override
    public Unidad getUnidad() {
        return this.unidad;
    }


}
