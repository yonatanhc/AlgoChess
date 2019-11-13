package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public  class Rango {
    private Tablero tablero;

    public  Rango(Tablero tablero){
        this.tablero = tablero;
    }


    public ArrayList<Unidad> listaDeUnidadesAfectados(int x, int y,int rango,ArrayList<Unidad> unidades){
        iterador(y - rango, y + rango, x - rango, unidades,true);
        iterador(y - rango, y + rango, x + rango, unidades,true);
        iterador(x - rango, x + rango, y - rango, unidades,false);
        iterador(x - rango, x + rango, y + rango, unidades,false);
        return unidades;
    }


    private void iterador(int x, int y, int constante, ArrayList<Unidad> unidades,boolean horizontal) {
        for (int i = x; i <= y; i++) {
            if(ubicacionValida(i,constante)){
                Casillero casillero;
                if(horizontal) casillero = this.tablero.obtenerCasillero(constante,i);
                else casillero = tablero.obtenerCasillero(i,constante);

                Unidad unidad = casillero.obtenerUnidad();
                if(unidad != null && !unidades.contains(unidad)){
                    unidades.add(unidad);
                }
            }

        }
    }
    /*
    private void iteradorVertical(int x, int y, int constante, ArrayList<Unidad> unidades) {
        for (int i = x; i <= y; i++) {
            if( i >= 1 && i <= 20 && constante >= 1 && constante <= 20){
                Casillero casillero = tablero.obtenerCasillero(i,constante);
                Unidad unidad = casillero.obtenerUnidad();
                if(unidad != null && !unidades.contains(unidad)){
                    unidades.add(unidad);
                }
            }
        }
    }*/

    private boolean ubicacionValida(int i,int constante){
        return ( i >= 1 && i <= 20 && constante >= 1 && constante <= 20);
    }
}