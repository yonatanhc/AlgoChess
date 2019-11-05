package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

public abstract class TipoDeAtaque {
    private int danioCuerpoAcuerpo;
    private int danioADistancia;

    public TipoDeAtaque(int danioCuerpoACuerpo, int danioADistancia) {
        this.danioCuerpoAcuerpo = danioCuerpoACuerpo;
        this.danioADistancia = danioADistancia;
    }

    public abstract void activarAtaque(Casillero origenDelAtaque);

    public void realizarDanioCuerpoAcuerpo(Casillero origenDelAtaque,int distanciaDelAtaque) {

    }

    public void realizarDanioADistancia(Casillero origenDelAtaque,int distanciaDelAtaque) {

    }

}
