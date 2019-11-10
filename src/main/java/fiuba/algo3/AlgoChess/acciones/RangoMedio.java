package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public class RangoMedio extends Rango{
    private int minimo;
    private int maximo;

    public RangoMedio(Tablero tablero){
        super(tablero);
        this.minimo = 3;
        this.maximo = 5;
    }

    public ArrayList<Unidad> listaDeUnidadesAfectados(int x, int y){
        ArrayList<Unidad> unidades;
        unidades = new  ArrayList<Unidad>();
        listaDeUnidades(x,y,this.minimo,unidades);
        listaDeUnidades(x,y,this.minimo+1,unidades);
        listaDeUnidades(x,y,this.maximo,unidades);
        return unidades;
    }
}
