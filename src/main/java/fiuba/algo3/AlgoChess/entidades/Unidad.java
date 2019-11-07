package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.TipoDeAtaque;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.Jugador;

public abstract class Unidad {
    private int vida;
    private int costo;
    private Casillero ubicacion;
    private Jugador jugador;
    protected TipoDeAtaque ataqueDeUnidad;
    protected String nombreDeUnidad;

    public Unidad(int vida, int costo) {
        this.vida = vida;
        this.costo = costo;
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

    public void atacarUnidad(Unidad unidadAAtacar){
        if( this.getJugador() != unidadAAtacar.getJugador()){
            unidadAAtacar.recibirDanio(ataqueDeUnidad.devolverPuntosDeAtaque());
        }
    }

    protected void sanarDanio(int devolverPuntosDeAtaque) {
        this.vida += devolverPuntosDeAtaque;
    }

    public String getNombreDeUnidad(){
        return this.nombreDeUnidad;
    }

}