package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public abstract class Habilidad {
    private Rango rango;

    public Habilidad(Rango rango) {
        this.rango = rango;
    }

    protected ArrayList<Unidad> listaDeUnidadesAfectadas(int x, int y,int rango, ArrayList<Unidad> unidades) {
        return this.rango.listaDeUnidadesAfectados(x,y,rango,unidades);
    }

    protected ArrayList<Unidad> filtrarUnidades(Unidad unidad,ArrayList<Unidad> unidades,boolean enemigas ){
       return rango.filtrarUnidades(unidad,unidades,enemigas);
    }

    public abstract void activarHabilidad(Unidad unidad);
}

