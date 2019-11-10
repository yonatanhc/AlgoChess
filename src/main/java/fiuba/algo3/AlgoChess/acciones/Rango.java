package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public abstract class Rango {
    private Tablero tablero;

    public  Rango(Tablero tablero){
        this.tablero = tablero;
    }


    public abstract ArrayList<Unidad> listaDeUnidadesAfectados(int x, int y);

    protected void listaDeUnidades(int x, int y, int rango, ArrayList<Unidad> unidades) {

        iteradorHorizontal(y - rango, y + rango, x - rango, unidades);
        iteradorHorizontal(y - rango, y + rango, x + rango, unidades);
        iteradorVertical(x - rango, x + rango, y - rango, unidades);
        iteradorVertical(x - rango, x + rango, y + rango, unidades);

    }

    private void iteradorHorizontal(int x, int y, int constante, ArrayList<Unidad> unidades) {
        for (int i = x; i <= y; i++) {
            Casillero casillero = this.tablero.obtenerCasillero(constante,i);
            Unidad unidad = casillero.obtenerUnidad();
            if(unidad != null && !unidades.contains(unidad)){//casillero aliado o enemigo
                unidades.add(unidad);
            }

        }
    }

    private void iteradorVertical(int x, int y, int constante, ArrayList<Unidad> unidades) {
        for (int i = x; i <= y; i++) {
            Casillero casillero = tablero.obtenerCasillero(i,constante);
            Unidad unidad = casillero.obtenerUnidad();
            if(unidad != null && !unidades.contains(unidad)){
                unidades.add(unidad);
            }

        }
    }
}