package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

public class AtaqueALejanaDistancia extends TipoDeAtaque {
    private int distanciaMinima;
    private int distanciaMaxima;

    public AtaqueALejanaDistancia(int danioCuerpoACuerpo, int danioADistancia) {
        super(danioCuerpoACuerpo,danioADistancia);
        this.distanciaMinima = 6;
        this.distanciaMaxima = 40; //Puede atacar a cualquier distancia
    }

    @Override
    public void activarAtaque(Casillero origenDelAtaque) {
        realizarDanioCuerpoAcuerpo(origenDelAtaque,this.distanciaMinima);
        realizarDanioADistancia(origenDelAtaque,this.distanciaMaxima);
    }
}
