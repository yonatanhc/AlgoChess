package fiuba.algo3.AlgoChess;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int puntos;
    private Tablero tablero;
    private ArrayList<Unidad> unidades;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 20;
        this.unidades = new ArrayList<Unidad>();
    }

    public void asignarTablero(Tablero tableroAliado) {
        this.tablero = tableroAliado;
    }

    public void agregarUnidad(Unidad unidad){
        if(unidad.getCosto() > this.puntos) throw new PuntosNoDisponibleDelJugador();
        this.puntos -= unidad.getCosto();
        unidad.perteneceAlJugador(this);
    }

    public void removerUnidad(Unidad unidad){
        for (int i = 0 ; i < unidades.size() ; i++){
            if(unidad.equals(this.unidades.get(i))){
                this.unidades.remove(i);
            }
        }
        if (unidades.size() == 0) throw  new JugadorPerdioElJuegoExcepcion();
    }

    public boolean casilleroAliado(Casillero casillero){
        return this.tablero.EsCasilleroAliado(casillero.getX(),casillero.getY());
    }
}
