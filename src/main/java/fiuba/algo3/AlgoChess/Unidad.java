package fiuba.algo3.AlgoChess;

public abstract class Unidad {
    private int vida;
    private int costo;
    private Casillero ubicacion;
    private Jugador jugador;

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
}