package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

public class Jugador {
    private String nombre;
    private int puntos;
    private ArrayList<Unidad> unidades;
    private ArrayList<Casillero> casillerosDelJugador;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 20;
        this.unidades = new ArrayList<Unidad>();
        this.casillerosDelJugador = new ArrayList<Casillero>();
    }
    public void agregarUnidad(Unidad unidad) {
        if (unidad.getCosto() <this.puntos) {
            this.puntos -= unidad.getCosto();
            unidades.add(unidad);
            unidad.perteneceAlJugador(this);
        } else {
            throw new PuntosNoDisponibleDelJugadorException();
        }
    }

    public boolean asignoTodasLasUnidades(){
        return puntos == 0;
    }

    public String obtenerNombre(){return this.nombre;}

    public void removerUnidad(Unidad unidad){
        for (int i = 0 ; i < unidades.size() ; i++){
            if(unidad.equals(this.unidades.get(i))){
                this.unidades.remove(i);
            }
        }
        if (unidades.size() == 0) throw  new JugadorPerdioElJuegoExcepcion();
    }

    public boolean esMiCampo(Casillero casilleroALlenar) {
        if(this.casillerosDelJugador.contains(casilleroALlenar)){
            return true;
        }else{
          //  throw new CampoContrarioException(); // Deberia enviar una excepcion?
            return false;
        }
    }

    /*
    public boolean esMiCampo(int x, int y) {
        if(x >= this.inicioDelCampo && x <= finDelCampo && y >= 1 && y <= 20){
             return true;
        }else{
            throw new CampoContrarioException();
        }
    }*/

    public int tamanioCampo(){
        return this.casillerosDelJugador.size();
    }

    public void campoDelJugador(Casillero casillero){
        this.casillerosDelJugador.add(casillero);
    }

    public boolean tieneUnidades(){ //A partir de este metodo, defino quien es el jugador ganador
        return (unidades.size() == 0 );
    }


    /*
    public void campoDelJugador(int inicio , int fin){
        this.inicioDelCampo = inicio;
        this.finDelCampo = fin;
    }*/


}
