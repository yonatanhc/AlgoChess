package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public abstract class Habilidad {
    private Rango rango;

    public Habilidad(Rango rango) {
        this.rango = rango;
    }

<<<<<<< HEAD
    protected ArrayList<Unidad> listaDeUnidadesAfectadas(int x, int y) {
        return rango.listaDeUnidadesAfectados(x, y);
    }

    public abstract void activarHabilidad(Unidad unidad);
}
=======
    public abstract void  activarHabilidad(Unidad unidad);

    protected ArrayList<Unidad> listaDeUnidadesAfectados(int x, int y,int rango,ArrayList<Unidad> unidades){
        return this.rango.listaDeUnidadesAfectados(x,y,rango,unidades);
    }

}
>>>>>>> ataque
