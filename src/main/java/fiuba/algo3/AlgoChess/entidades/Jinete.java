package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.Ataque;
import fiuba.algo3.AlgoChess.acciones.RangoMedio;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

public class Jinete extends Unidad {

    public Jinete() {
        super(100, 3);
        this.nombreDeUnidad = "Jinete";
    }

    public void asignarHabilidad(){
        asignarTipoDeHabilidad(new Ataque(new RangoMedio(getTablero()),5,15));
    }

    public void activarHabilidad(){
        getTipoDeHabilidad().activarHabilidad(this);
    }

}