package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.Habilidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public abstract class Unidad {
    private int vida;
    private int costo;
    private Casillero ubicacion;
    private Tablero tablero;
    private Jugador jugador;
    private Habilidad tipoDeHabilidad;
    protected String nombreDeUnidad;

    public Unidad(int vida, int costo) {
        this.vida = vida;
        this.costo = costo;
    }

    protected void asignarTipoDeHabilidad(Habilidad habilidad){
        this.tipoDeHabilidad = habilidad;
    }

    public void asignarTablero(Tablero tablero){
        this.tablero = tablero;
    }

    protected Habilidad getTipoDeHabilidad(){
        return this.tipoDeHabilidad;
    }


    public abstract void activarHabilidad();

    protected Tablero getTablero(){
        return this.tablero;
    }

    public void perteneceAlJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getPuntosDeVida() {
        return this.vida;
    }

    public int getCosto() {
        return this.costo;
    }

    public Jugador getJugador(){
        return this.jugador;
    }

    public void setUbicacion(Casillero ubicacion) {
        ubicacion.ocuparCasilleroConUnidad(this);
        this.ubicacion = ubicacion;
    }

    public Casillero getUbicacion() {
        return this.ubicacion;
    }

    public void recibirDanio(int danio) {
        //if(!jugador.casilleroAliado(this.ubicacion)) danio += (0.5*danio);
        this.vida -= danio;
        if (this.vida <= 0) {
            jugador.removerUnidad(this);
        }
    }

    protected void sanarDanio(int devolverPuntosDeAtaque) {
        this.vida += devolverPuntosDeAtaque;
    }

    public String getNombreDeUnidad(){
        return this.nombreDeUnidad;
    }



}