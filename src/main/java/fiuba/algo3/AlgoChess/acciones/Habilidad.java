package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
<<<<<<< Updated upstream
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public abstract class Habilidad {
    private Rango rango;

    public Habilidad(Rango rango) {
        this.rango = rango;
    }

    protected ArrayList<Unidad> listaDeUnidadesAfectadas(int x, int y){
        return rango.listaDeUnidadesAfectados(x , y);
    }

    public abstract void  activarHabilidad(Unidad unidad);


public interface Habilidad {

    public void  atacar();

    public void curar(Unidad unidad);


}
