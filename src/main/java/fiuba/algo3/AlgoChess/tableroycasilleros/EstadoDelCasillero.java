package fiuba.algo3.AlgoChess.tableroycasilleros;

import fiuba.algo3.AlgoChess.entidades.Unidad;

public interface EstadoDelCasillero {
    public boolean estaLibre();

    public Unidad getUnidad();
}
