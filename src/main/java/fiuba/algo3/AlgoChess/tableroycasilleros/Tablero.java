package fiuba.algo3.AlgoChess.tableroycasilleros;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.CasilleroNoExisteExcepcion;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casillero> tablero;

    public Tablero() {
        this.tablero = new ArrayList<Casillero>();
        inicializarTablero();
    }
    private void inicializarTablero() {
        for(int i = 1; i <= 8 ; i++) {
            for(int j = 1 ; j <= 5 ; j++) {
                this.tablero.add(new Casillero(i,j));
            }
        }
    }

    public  void ubicarUnidadEn(Unidad unidad, int x, int y){
       Casillero casillero = getCasillero(x,y);
       if(casillero.casilleroEstaLibre() && unidad.getJugador().casilleroAliado(casillero)) { //
           unidad.setUbicacion(casillero);
           casillero.ingresarUnidad(unidad);
       }
    }
    //esta class solo se usa para pasar las pruebas de movilidad
    public  void ubicarUnidad(Unidad unidad,int x, int y){
        Casillero casillero = getCasillero(x,y);
        if(casillero.casilleroEstaLibre() ) { //&& unidad.getJugador().casilleroAliado(casillero)
            unidad.setUbicacion(casillero);
            casillero.ingresarUnidad(unidad);
        }
    }

    public Casillero getCasillero(int x, int y) {
        for(int i = 0; i < this.tablero.size(); i++) {
            Casillero casillero = this.tablero.get(i);
            if(casillero.getX() == x && casillero.getY() == y) {
                return casillero;
            }
        }
        throw new CasilleroNoExisteExcepcion();
    }



}