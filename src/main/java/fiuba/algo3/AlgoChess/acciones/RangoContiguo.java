package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public class RangoContiguo extends Rango {
    private int maximo;

    public RangoContiguo(Tablero tablero){
        super(tablero);
        this.maximo = 1;
    }

    public ArrayList<Unidad> listaDeUnidadesAfectados(int x, int y){
        ArrayList<Unidad> unidades;
        unidades = new  ArrayList<Unidad>();
        listaDeUnidades(x,y,this.maximo,unidades);
        return unidades;
    }




}
