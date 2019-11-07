package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.AtaqueACortaDistancia;
import fiuba.algo3.AlgoChess.acciones.Movilidad;
import fiuba.algo3.AlgoChess.acciones.TipoDeAtaque;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

public class Soldado extends Unidad {
    private Movilidad movilidad;

    public Soldado(){
        super(100,1);
        this.movilidad = new Movilidad();
        this.ataqueDeUnidad = new AtaqueACortaDistancia(10);
    }

    public void moverUnidadA(int x, int y, Tablero tablero) {
        Casillero destino = tablero.obtenerCasillero(x, y);
        this.movilidad.moverUnidadA(this, getUbicacion(), destino);
    }

    public void atacarUnidad(Unidad unidadAAtacar){
        unidadAAtacar.recibirDanio(ataqueDeUnidad.devolverPuntosDeAtaque());
    }
}