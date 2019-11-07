package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

public abstract class TipoDeAtaque {
    private int puntosDeAtaque;

    public TipoDeAtaque(int puntos) {
        this.puntosDeAtaque = puntos;
    }

    public abstract void activarAtaque(Casillero origenDelAtaque);

    public void realizarDanioCuerpoAcuerpo(Casillero origenDelAtaque,int distanciaDelAtaque) {

    }

    public void realizarDanioADistancia(Casillero origenDelAtaque,int distanciaDelAtaque) {

    }

    public int devolverPuntosDeAtaque(){
        return this.puntosDeAtaque;
    }

}
